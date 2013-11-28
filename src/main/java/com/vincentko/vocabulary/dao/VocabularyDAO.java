package com.vincentko.vocabulary.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vincentko.feedaggregate.object.Article;
import com.vincentko.vocabulary.object.Vocabulary;
import com.vincentko.vocabulary.object.VocabularyCategory;

@Repository
public class VocabularyDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Vocabulary> listVocabulary() {
		String sql= "from Vocabulary";

		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery(sql);
		
		List<Vocabulary> list= qry.setMaxResults(100).list();

		return list;
	}
	
	public void addVocabulary(Vocabulary Vocabulary) {
		sessionFactory.getCurrentSession().save(Vocabulary);
	}
	
	public void addVocabularyCategory(VocabularyCategory vocabularyCategory) {
		sessionFactory.getCurrentSession().save(vocabularyCategory);
	}
	
	public void removeVocabulary(Integer id) {
		Vocabulary vocabulary = (Vocabulary) sessionFactory.getCurrentSession().load(
				Vocabulary.class, id);
		if (null != vocabulary) {
			sessionFactory.getCurrentSession().delete(vocabulary);
		}

	}
	
	public List<VocabularyCategory> listVocabularyCategory() {
		String sql= "from VocabularyCategory";

		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery(sql);
		
		List<VocabularyCategory> list= qry.list();

		return list;
	}
}



