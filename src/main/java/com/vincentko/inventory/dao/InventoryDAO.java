package com.vincentko.inventory.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vincentko.feedaggregate.object.Article;
import com.vincentko.inventory.object.Inventory;
import com.vincentko.inventory.object.InventoryCategory;
import com.vincentko.inventory.object.InventoryCategoryLink;
import com.vincentko.taskreminder.object.Task;
import com.vincentko.vocabulary.object.Vocabulary;
import com.vincentko.vocabulary.object.VocabularyCategory;

@Repository
public class InventoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Inventory getInventoryById(Integer iId) {

		Inventory inventory = (Inventory) sessionFactory.getCurrentSession().load(
				Inventory.class, iId);		
		System.out.println(inventory.getItemName());
		return inventory;
	}
	
	public Integer getInventoryIdLatestOne() {
		
		Integer itemId = 0;
		
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Inventory.class, "i");
		c.setProjection(Projections.property("i.itemId"));
		c.addOrder(Order.desc("i.itemId"));
		c.setMaxResults(1);

		
		List<Inventory> list= c.list();
		
		for (Inventory i : list){
			itemId = i.getItemId();
		}

		return itemId;
	}
	
	public List<Inventory> getInventoryByCategory(Integer catId) {
				
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Inventory.class, "i");
		c.createAlias("i.inventoryCategoryLinks", "icl");
		c.createAlias("icl.inventoryCategory", "ic");
		c.add(Restrictions.eq("ic.categoryId", catId));		
		
		List<Inventory> list= c.list();
		
		return list;
	}
	
	public InventoryCategory getInventoryCategoryById(Integer catId) {
			
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(InventoryCategory.class, "ic");		
		c.add(Restrictions.eq("ic.categoryId", catId));		
		c.setMaxResults(1);	
		List<InventoryCategory> list= c.list();		

		return list.get(0);
	}
	
	public List<InventoryCategory> listInventoryCategory() {
		String sql= "from InventoryCategory";

		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery(sql);
		
		List<InventoryCategory> list= qry.list();

		return list;
	}
	
	public List<InventoryCategoryLink> getInventoryCategoryLinkByCategory(Integer catId) {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(InventoryCategoryLink.class, "icl");
		c.createAlias("icl.inventory", "i");
		c.createAlias("icl.inventoryCategory", "ic");
		c.add(Restrictions.eq("ic.categoryId", catId));		
		c.add(Restrictions.eq("i.itemDisable", 0));
		List<InventoryCategoryLink> list= c.list();
		
		return list;
	}
	
	public void addInventory(Inventory inventory) {
		sessionFactory.getCurrentSession().saveOrUpdate(inventory);
	}
	
	public void addInventoryCategory(InventoryCategory inventoryCategory) {
		sessionFactory.getCurrentSession().save(inventoryCategory);
	}
	
	public void addInventoryCategoryLink(InventoryCategoryLink icl) {
		sessionFactory.getCurrentSession().save(icl);
	}
	
	public void disableInventory(Integer iId) {
		Inventory inventory = (Inventory) sessionFactory.getCurrentSession().load(
				Inventory.class, iId);
		inventory.setItemDisable(1);
		if (null != inventory) {
			sessionFactory.getCurrentSession().saveOrUpdate(inventory);
		}
	}
}



