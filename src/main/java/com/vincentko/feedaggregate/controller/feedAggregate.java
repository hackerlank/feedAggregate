package com.vincentko.feedaggregate.controller;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vincentko.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vincentko.encryption.Encrypt;
import com.vincentko.feedaggregate.object.Article;
import com.vincentko.feedaggregate.object.Feed;
import com.vincentko.feedaggregate.object.FeedCategory;
import com.vincentko.feedaggregate.object.FeedChannel;
import com.vincentko.feedaggregate.service.FeedService;
import com.vincentko.financialstatement.object.PayCheck;
import com.vincentko.taskreminder.service.TaskReminderService;
import com.vincentko.taskreminder.object.Task;

@Controller
public class feedAggregate {

//  @RequestMapping(value="/index",method=RequestMethod.GET)
//  public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
//    
//    return new ModelAndView("home");
//  }

	@Autowired private FeedService feedService;
	@Autowired private TaskReminderService taskService;
	
	@RequestMapping("/index")
	public String listFeeds(Map<String, Object> map) {
		
		//Event Reminder
		List<Task> list= taskService.listReminderEvent();
		
		map.put("event", new Task());
		map.put("eventList", taskService.listReminderEvent());	//All Event Reminder
		map.put("eventEffective", new Task());
		map.put("eventEffectiveList", taskService.listEffectiveEvent());	//All Event Effective

		return "home";
	}

	@RequestMapping("/filterfeeds")
	public String filterFeeds(Map<String, Object> map, @RequestParam("catId") Integer catId, @RequestParam("startDate") String stringStartDate, @RequestParam("endDate") String stringEndDate, @RequestParam("limit") Integer limit) throws ParseException {
		VincentKoUtil util = new VincentKoUtil();
		
		Calendar startDate = util.dateAdd(-1000);
		Calendar endDate = util.dateAdd(1);
		
		if(stringStartDate!=null && stringStartDate!="") startDate.setTime(util.convertStringToDate(stringStartDate));
		if(stringEndDate!=null  && stringEndDate!="") {
			endDate.setTime(util.convertStringToDate(stringEndDate));
			util.setEndOfDay(endDate);
		}
		
/*		System.out.println(startDate.getTime());
		System.out.println(endDate.getTime());
		System.out.println("-----------------");*/
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());
		map.put("feedList", feedService.getFeedByCategoryId(catId,startDate,endDate,limit));	//All Feeds	
		return "feed";
	}
	
	@RequestMapping("/newfeedchannel")
	public String newFeedChannel(Map<String, Object> map) {
		map.put("channel", new FeedChannel());
		return "feed_channel_new";
	}
	
	@RequestMapping(value = "/addfeedchannel", method = RequestMethod.POST)
	public String addFeedChannel(@ModelAttribute("feedChannel")
	FeedChannel feedChannel, BindingResult result) {

		feedService.addFeedChannel(feedChannel);
		
		return "redirect:/feed.html";
	}
	
	@RequestMapping("/newfeedcategory")
	public String newFeedCategory(Map<String, Object> map) {
		map.put("channel", new FeedChannel());
		map.put("chList", feedService.listChannel());	//All Channels		
		map.put("category", new FeedCategory());
		return "feed_category_new";
	}
	
	@RequestMapping(value = "/addfeedcategory", method = RequestMethod.POST)
	public String addFeedCategory(@ModelAttribute("feedCategory")
	FeedCategory feedCategory, BindingResult result) {

		feedService.addFeedCategory(feedCategory);
		
		return "redirect:/feed.html";
	}
	
	@RequestMapping("/articles")
	public String listArticle(Map<String, Object> map) {
		
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("article", new Article());
		map.put("articleList", feedService.listArticle());	//All Feeds	
		return "article";
	}
	
	@RequestMapping("/filterarticles")
	public String filterArticles(Map<String, Object> map, @RequestParam("catId") Integer catId, @RequestParam("startDate") String stringStartDate, @RequestParam("endDate") String stringEndDate, @RequestParam("limit") Integer limit) throws ParseException {
		VincentKoUtil util = new VincentKoUtil();
		
		Calendar startDate = util.dateAdd(-1000);
		Calendar endDate = util.dateAdd(1);
		
		if(stringStartDate!=null && stringStartDate!="") startDate.setTime(util.convertStringToDate(stringStartDate));
		if(stringEndDate!=null  && stringEndDate!="") {
			endDate.setTime(util.convertStringToDate(stringEndDate));
			util.setEndOfDay(endDate);
		}

		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("article", new Article());
		map.put("articleList", feedService.getArticleByCategoryId(catId,startDate,endDate,limit));	//All Feeds	
		return "article";
	}

	@RequestMapping("/newarticle")
	public String newArticle(Map<String, Object> map) {
		map.put("article", new Article());
		map.put("category", new FeedCategory());
		map.put("channel", new FeedChannel());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("chList", feedService.listChannel());	//All Channels
		return "article_new";
	}
	
	@RequestMapping(value = "/addarticle", method = RequestMethod.POST)
	public String addArticle(@ModelAttribute("article")
	Article article, BindingResult result) {

		article.setPubDate(Calendar.getInstance());

		feedService.addArticle(article);
		
		return "redirect:/articles.html";
	}
	
    @RequestMapping(value="/deletearticle", method = RequestMethod.POST)
    public String deleteArticle(@ModelAttribute("article") Article article,BindingResult result, @RequestParam("articleId") Integer articleId, Model model) {
    
		feedService.removeArticle(articleId);
		
		return "redirect:/articles.html";
    }
    
	@RequestMapping("/feed")
	public String listFeedsAll(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());
		map.put("feedList", feedService.listFeed());	//All Feeds	
		return "feed";
	}

	@RequestMapping("/feedfavorite")
	public String listFeedsFavorite(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());
		map.put("feedList", feedService.listFeedFavorite());	//All Favorite Feeds
		return "feed_favorite";
	}
	
	
	@RequestMapping("/addfavorite/{itemId}/add")
	public String addFeedFavorite(@PathVariable("itemId")
	Integer itemId) {
		
		feedService.updateFeedAsFavorite(itemId);

		return "redirect:/feedfavorite.html";
	}	
	
	@RequestMapping("/cnn")
	public String listFeedsCNN(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());
		map.put("feedList", feedService.listFeedCh(1));	//CNN Channel
		return "feed";
	}
	
	@RequestMapping("/cnntopstories")
	public String listFeedsCNNtopstories(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());
		map.put("feedList", feedService.listFeedCat(1,1));	//CNN-Top Stories
		return "feed";
	}	

	@RequestMapping("/cnnbusiness")
	public String listFeedsCNNcnnbusiness(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());
		map.put("feedList", feedService.listFeedCat(1,2));	//CNN-Business
		return "feed";
	}	

	@RequestMapping("/vnexpress")
	public String listFeedsVnexpress(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());
		map.put("feedList", feedService.listFeedCh(15));	//VnExpress
		return "feed";
	}
	
	@RequestMapping("/vnexpresstinmoinhat")
	public String listFeedsVnexpresstinmoinhat(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());
		map.put("feedList", feedService.listFeedCat(15,35));	//VnExpress - Tin Moi Nhat
		return "feed";
	}

	@RequestMapping("/vnexpressthegioi")
	public String listFeedsVnexpressthegioi(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());
		map.put("feedList", feedService.listFeedCat(15,36));	//VnExpress - The Gioi
		return "feed";
	}
	
	@RequestMapping("/aolrealestate")
	public String listFeedsAOLrealestate(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());
		map.put("feedList", feedService.listFeedCh(7));	//AOL Channel	
		return "feed";
	}

	@RequestMapping("/realestatemain")
	public String listFeedsAOLrealestatemain(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());
		map.put("feedList", feedService.listFeedCat(7,13));	//AOL Real Estate Main
		return "feed";
	}
	
	@RequestMapping("/realestatehowto")
	public String listFeedsAOLrealestatehowto(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());
		map.put("feedList", feedService.listFeedCat(7,14));	//AOL Real Estate How-to
		return "feed";
	}
	
	@RequestMapping("/realestateforclosures")
	public String listFeedsAOLrealestateforclosures(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(7,15));	//AOL Real Estate Forclosures
		return "feed";
	}
	
	@RequestMapping("/investorwords")
	public String listFeedsInvestorwords(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCh(8));	//Investor Words
		return "feed";
	}
	
	@RequestMapping("/investingterms")
	public String listFeedsInvestingterms(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(8,16));	//Investing Terms
		return "feed";
	}
	
	@RequestMapping("/businessterms")
	public String listFeedsBusinessterms(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(8,17));	//Business Terms
		return "feed";
	}
	
	@RequestMapping("/dailymarket")
	public String listFeedsDailymarket(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(8,20));	//Daily Market
		return "feed";
	}
	
	@RequestMapping("/weeklymarket")
	public String listFeedsWeeklymarket(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(8,18));	//Weekly Market
		return "feed";
	}
	
	@RequestMapping("/stockmarket")
	public String listFeedsStockmarket(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(8,19));	//Stock Market
		return "feed";
	}

	@RequestMapping("/tax")
	public String listFeedsTax(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories		
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCh(9));	//TAX
		return "feed";	
	}
	
	@RequestMapping("/tas")
	public String listFeedsTas(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(9,21));	//TAS
		return "feed";
	}
	
	@RequestMapping("/taxvox")
	public String listFeedsTaxvox(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(9,22));	//Tax Vox
		return "feed";
	}
	
	@RequestMapping("/taxnumber")
	public String listFeedsTaxnumber(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(9,23));	//Tax Number
		return "feed";
	}

	@RequestMapping("/sql")
	public String listFeedsSql(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories		
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCh(10));	//SQL
		return "feed";	
	}
	
	@RequestMapping("/sqlservercentral")
	public String listFeedsSqlservercentral(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(10,24));	//SQLServer Central
		return "feed";
	}
	
	@RequestMapping("/richdad")
	public String listFeedsRichDad(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories		
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCh(11));	//Rich Dad Education
		return "feed";	
	}
	
	@RequestMapping("/richdadrealestate")
	public String listFeedsRichDadRealEstate(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(11,25));	//Rich Dad - Real Estate
		return "feed";
	}
	
	@RequestMapping("/richdadstock")
	public String listFeedsRichDadStock(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(11,26));	//Rich Dad - Stock
		return "feed";
	}	
	
	@RequestMapping("/investopedia")
	public String listFeedsInvestopedia(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories		
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCh(14));	//Investopedia
		return "feed";	
	}
	
	@RequestMapping("/investopediaheadlines")
	public String listFeedsInvestopediaheadlines(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(14,31));	//Investopedia - Headlines
		return "feed";
	}
	
	@RequestMapping("/investopediafinanceguide")
	public String listFeedsInvestopediafinanceguide(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(14,32));	//Investopedia - Finance Guide
		return "feed";
	}	
	
	@RequestMapping("/investopediaterm")
	public String listFeedsInvestopediaterm(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(14,33));	//Investopedia - Term of Day
		return "feed";
	}
	
	@RequestMapping("/investopediafaq")
	public String listFeedsInvestopediafaq(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(14,34));	//Investopedia - FAQs
		return "feed";
	}	
	
	@RequestMapping("/bodybuilding")
	public String listFeedsBodyBuilding(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories		
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCh(12));	//Body Buildings
		return "feed";	
	}
	
	@RequestMapping("/bballarticles")
	public String listFeedsBodyBuildingAllArticles(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(12,27));	//Body Buildings - All articles
		return "feed";
	}
	
	@RequestMapping("/car")
	public String listFeedsCar(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories		
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCh(13));	//Car
		return "feed";	
	}
	
	@RequestMapping("/tccallarticles")
	public String listFeedsTccAllArticles(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(13,28));	//TCC - All Articles
		return "feed";
	}
	
	@RequestMapping("/tcctipadvice")
	public String listFeedsTccTipAdvice(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(13,29));	//TCC - Tip/Advice
		return "feed";
	}	
	
	@RequestMapping("/tccbottomline")
	public String listFeedsTccBottomLine(Map<String, Object> map) {
		map.put("category", new FeedCategory());
		map.put("catList", feedService.listCategory());	//All Categories
		map.put("feed", new Feed());	
		map.put("feedList", feedService.listFeedCat(13,30));	//TCC - Bottom Line
		return "feed";
	}	
} 