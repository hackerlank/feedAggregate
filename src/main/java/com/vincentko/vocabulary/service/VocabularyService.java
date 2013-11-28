package com.vincentko.vocabulary.service;

import java.util.Collections;
import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vincentko.vocabulary.dao.VocabularyDAO;
import com.vincentko.vocabulary.object.Vocabulary;
import com.vincentko.vocabulary.object.VocabularyCategory;


@Service
public class VocabularyService {

	@Autowired
	private VocabularyDAO vDAO;

	@Transactional
	public List<Vocabulary> listVocabulary() {
		return vDAO.listVocabulary();
	}
		
	
	@Transactional
	public void addVocabulary(Vocabulary vocabulary) {
		vDAO.addVocabulary(vocabulary);
	}
	
	@Transactional
	public void addVocabularyCategory(VocabularyCategory vocabularyCategory) {
		vDAO.addVocabularyCategory(vocabularyCategory);
	}

	@Transactional
	public void removeVocabulary(Integer id) {
		vDAO.removeVocabulary(id);
	}
	
	@Transactional
	public List<VocabularyCategory> listVocabularyCategory() {
		return vDAO.listVocabularyCategory();
	}
	
	@Transactional
	public List<Vocabulary> listVocabularyByRandom() {
		List<Vocabulary> list = vDAO.listVocabulary();
		Collections.shuffle(list);
		return list;
	}
	
}
