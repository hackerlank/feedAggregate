package com.vincentko.vocabulary.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vincentko.feedaggregate.object.Article;
import com.vincentko.feedaggregate.object.FeedCategory;
import com.vincentko.feedaggregate.object.FeedChannel;
import com.vincentko.vocabulary.object.Vocabulary;
import com.vincentko.vocabulary.object.VocabularyCategory;
import com.vincentko.vocabulary.service.VocabularyService;

@Controller
public class VocabularyController {

//  @RequestMapping(value="/index",method=RequestMethod.GET)
//  public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
//    
//    return new ModelAndView("home");
//  }

	@Autowired private VocabularyService vService;
	
	
	@RequestMapping("/vocabulary")
	public String listVocabulary(Map<String, Object> map) {

		map.put("vocabulary", new Vocabulary());
		map.put("vocabularyList", vService.listVocabulary());	//All Tasks
		return "vocabulary";
	}
	
	@RequestMapping(value = "/addvocabulary", method = RequestMethod.POST)
	public String addVocabulary(@ModelAttribute("vocabulary")
	Vocabulary vocabulary, BindingResult result) {
		
		vocabulary.setPubDate(Calendar.getInstance());
		vService.addVocabulary(vocabulary);

		return "redirect:/vocabulary.html";
	}

	
	@RequestMapping("/newvocabulary")
	public String newVocabulary(Map<String, Object> map) {
		
		map.put("vocabulary", new Vocabulary());
		map.put("category", new VocabularyCategory());
		map.put("catList", vService.listVocabularyCategory());	//All Categories
		return "vocabulary_new";
	}
				
    @RequestMapping(value="/deletevocabulary", method = RequestMethod.POST)
    public String deleteVocabulary(@ModelAttribute("vocabulary") Vocabulary vocabulary,BindingResult result, @RequestParam("vocabId") Integer vocabId, Model model) {
    
		vService.removeVocabulary(vocabId);
		
		return "redirect:/vocabulary.html";
    }

	@RequestMapping(value = "/addvocabularycategory", method = RequestMethod.POST)
	public String addVocabularyCategory(@ModelAttribute("vocabularycategory")
	VocabularyCategory vocabularycategory, BindingResult result) {
		
		vService.addVocabularyCategory(vocabularycategory);

		return "redirect:/vocabulary.html";
	}

	
	@RequestMapping("/newvocabularycategory")
	public String newVocabularyCategory(Map<String, Object> map) {
		map.put("vocabularycategory", new VocabularyCategory());
		return "vocabulary_category_new";
	}
	
}