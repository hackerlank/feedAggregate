package com.vincentko.feedaggregate.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vincentko.feedaggregate.dao.FeedDAO;
import com.vincentko.feedaggregate.object.Article;
import com.vincentko.feedaggregate.object.Feed;
import com.vincentko.feedaggregate.object.FeedCategory;
import com.vincentko.feedaggregate.object.FeedChannel;
import com.vincentko.taskreminder.object.Task;

@Service
public class FeedService {

	@Autowired
	private FeedDAO feedDAO;

	@Transactional
	public List<Feed> listFeed() {
		return feedDAO.listFeed();
	}

	
	@Transactional
	public List<Feed> listFeedCh(int fch) {
		return feedDAO.listFeedCh(fch);
	}
	
	@Transactional
	public List<Feed> listFeedCat(int fch, int fca) {
		return feedDAO.listFeedCat(fch, fca);
	}

	@Transactional
	public List<Feed> getFeedByCategoryId(Integer catId, Calendar startDate, Calendar endDate, Integer limit) {
		return feedDAO.getFeedByCategoryId(catId,startDate,endDate,limit);
	}
	
	@Transactional
	public List<Feed> listFeedFavorite() {
		return feedDAO.listFeedFavorite();
	}
	
	@Transactional
	public void updateFeedAsFavorite(Integer itemId) {
		feedDAO.updateFeedAsFavorite(itemId);
	}	
	
	@Transactional
	public List<Article> listArticle() {
		return feedDAO.listArticle();
	}
	
	@Transactional
	public List<Article> getArticleByCategoryId(Integer catId, Calendar startDate, Calendar endDate, Integer limit) {
		return feedDAO.getArticleByCategoryId(catId,startDate,endDate,limit);
	}
	
	@Transactional
	public void addArticle(Article article) {
		feedDAO.addArticle(article);
	}
	
	@Transactional
	public void removeArticle(Integer id) {
		feedDAO.removeArticle(id);
	}
	
	@Transactional
	public List<FeedCategory> listCategory() {
		return feedDAO.listCategory();
	}
	
	@Transactional
	public List<FeedChannel> listChannel() {
		return feedDAO.listChannel();
	}
	
	@Transactional
	public void addFeedChannel(FeedChannel feedChannel) {
		feedDAO.addFeedChannel(feedChannel);
	}

	@Transactional
	public void addFeedCategory(FeedCategory feedCategory) {
		feedDAO.addFeedCategory(feedCategory);
	}	
}
