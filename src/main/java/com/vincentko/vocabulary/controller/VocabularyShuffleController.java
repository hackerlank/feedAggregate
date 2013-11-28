package com.vincentko.vocabulary.controller;

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
public class VocabularyShuffleController {


	@Autowired private VocabularyService vService;
	
	
	@RequestMapping("/shufflevocabulary")
	public String listVocabulary(Map<String, Object> map) {

		map.put("vocabulary", new Vocabulary());
		map.put("vocabularyList", vService.listVocabularyByRandom());	//All Tasks
		return "vocabulary_shuffle";
	}
	

	
}