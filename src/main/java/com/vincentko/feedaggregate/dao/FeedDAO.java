package com.vincentko.feedaggregate.dao;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.vincentko.feedaggregate.object.Feed;
import com.vincentko.feedaggregate.object.Article;
import com.vincentko.feedaggregate.object.FeedCategory;
import com.vincentko.feedaggregate.object.FeedChannel;
import com.vincentko.taskreminder.object.Task;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FeedDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Feed> listFeed() {
		String sql= "SELECT new Feed(fch,fca,f.itemId,f.title,f.description,f.guid,f.pubDateConverted) from Feed f " +
					"JOIN f.feedChannel fch JOIN f.feedCategory fca " +
					"ORDER BY f.pubDateConverted DESC";
		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery(sql);
		
		List<Feed> list= qry.setMaxResults(50).list();

		return list;
	}

	public List<Feed> listFeedCh(int fch) {
		String sql= "SELECT new Feed(fch,fca,f.itemId,f.title,f.description,f.guid,f.pubDateConverted) from Feed f " +
				"JOIN f.feedChannel fch JOIN f.feedCategory fca " +
				"WHERE fch.channelId=:fch " +
				"ORDER BY f.pubDateConverted DESC";
		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery(sql);
		qry.setParameter("fch", fch);
		
		List<Feed> list= qry.setMaxResults(50).list();

		return list;
	}
	
	public List<Feed> listFeedCat(int fch, int fca) {
		String sql= "SELECT new Feed(fch,fca,f.itemId,f.title,f.description,f.guid,f.pubDateConverted) from Feed f " +
					"JOIN f.feedChannel fch JOIN f.feedCategory fca " +
					"WHERE fch.channelId=:fch AND fca.categoryId=:fca " +
					"ORDER BY f.pubDateConverted DESC";
		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery(sql);
		qry.setParameter("fch", fch);
		qry.setParameter("fca", fca);
		
		List<Feed> list= qry.setMaxResults(50).list();
		
		return list;
	}

	public List<Feed> getFeedByCategoryId(Integer catId, Calendar startDate, Calendar endDate, Integer limit) {

		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Feed.class, "f");
		c.createAlias("f.feedCategory", "fc");
		c.add(Restrictions.eq("fc.categoryId", catId));	
		c.add(Restrictions.between("f.pubDateConverted", startDate, endDate));
		c.addOrder(Order.desc("f.pubDateConverted"));

		
		List<Feed> list= c.setMaxResults(limit).list();
		for (Feed f: list) {
			System.out.println(f.getPubDateConverted().getTime());
		}
		return list;
	}
	
	public List<Feed> listFeedFavorite() {
		String sql= "SELECT new Feed(fch,fca,f.itemId,f.title,f.description,f.guid,f.pubDateConverted) from Feed f " +
					"JOIN f.feedChannel fch JOIN f.feedCategory fca " +
					"WHERE f.feedIsFavorite=1 " +
					"ORDER BY f.pubDateConverted DESC";
		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery(sql);
		
		List<Feed> list= qry.setMaxResults(50).list();

		return list;
	}
	
	public void updateFeedAsFavorite(Integer itemId) {
		Feed feed = (Feed) sessionFactory.getCurrentSession().load(
				Feed.class, itemId);
		feed.setFeedIsFavorite(1);
		if (null != feed) {
			sessionFactory.getCurrentSession().update(feed);
		}
	}	
	
	public List<Article> listArticle() {
		String sql= "from Article a " +				
					"ORDER BY a.pubDate DESC";
		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery(sql);
		
		List<Article> list= qry.setMaxResults(50).list();

		return list;
	}
	
	public List<Article> getArticleByCategoryId(Integer catId, Calendar startDate, Calendar endDate, Integer limit) {

		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Article.class, "a");
		c.createAlias("a.feedCategory", "fc");
		c.add(Restrictions.eq("fc.categoryId", catId));	
		c.add(Restrictions.between("a.pubDate", startDate, endDate));
		c.addOrder(Order.desc("a.pubDate"));
		
		List<Article> list= c.setMaxResults(limit).list();

		return list;
	}
	
	public void addArticle(Article article) {
		sessionFactory.getCurrentSession().save(article);
	}
	

	public void removeArticle(Integer id) {
		Article article = (Article) sessionFactory.getCurrentSession().load(
				Article.class, id);
		if (null != article) {
			sessionFactory.getCurrentSession().delete(article);
		}

	}
	
	public List<FeedCategory> listCategory() {
		String sql= "SELECT new FeedCategory(fc.categoryId, fc.categoryName, fch) from FeedCategory fc JOIN fc.feedChannel fch ORDER BY fch.channelName";
		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery(sql);
		
		List<FeedCategory> list= qry.list();

		return list;
	}
	
	public List<FeedChannel> listChannel() {
		String sql= "from FeedChannel fch ORDER BY fch.channelName";
		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery(sql);
		
		List<FeedChannel> list= qry.list();

		return list;
	}
	
	public void addFeedChannel(FeedChannel feedChannel) {
		sessionFactory.getCurrentSession().save(feedChannel);
	}

	public void addFeedCategory(FeedCategory feedCategory) {
		sessionFactory.getCurrentSession().save(feedCategory);
	}
	
	
}
