package com.vincentko.inventory.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;











import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vincentko.inventory.dao.InventoryDAO;
import com.vincentko.inventory.object.Inventory;
import com.vincentko.inventory.object.InventoryCategory;
import com.vincentko.inventory.object.InventoryCategoryLink;
import com.vincentko.vocabulary.dao.VocabularyDAO;
import com.vincentko.vocabulary.object.Vocabulary;
import com.vincentko.vocabulary.object.VocabularyCategory;


@Service
public class InventoryService {

	@Autowired
	private InventoryDAO iDAO;

	@Transactional
	public Inventory getInventoryById(Integer iId)  {
		return iDAO.getInventoryById(iId);
	}

	@Transactional
	public List<InventoryCategory> listInventoryCategory()  {
		return iDAO.listInventoryCategory();
	}
	
	@Transactional
	public InventoryCategory getInventoryCategoryById(Integer catId)  {
		return iDAO.getInventoryCategoryById(catId);
	}
	
	@Transactional
	public void addInventory(Inventory inventory) {
		iDAO.addInventory(inventory);
	}
	
	@Transactional
	public void addInventoryCategory(InventoryCategory inventoryCategory) {
		iDAO.addInventoryCategory(inventoryCategory);
	}
	
	@Transactional
	public void addInventoryCategoryLink(InventoryCategoryLink icl) {
		iDAO.addInventoryCategoryLink(icl);
	}
	
	@Transactional
	public Integer getInventoryIdLatestOne()  {
		return iDAO.getInventoryIdLatestOne();
	}
	
	@Transactional
	public List<List<InventoryCategoryLink>>  prepareInventoryByCategory()  {
		List<List<InventoryCategoryLink>> listOfListInventory = new ArrayList<List<InventoryCategoryLink>>();
		List<InventoryCategory> listIc = listInventoryCategory();
		for (InventoryCategory Ic : listIc){
			List<InventoryCategoryLink> i = iDAO.getInventoryCategoryLinkByCategory(Ic.getCategoryId());
			listOfListInventory.add(i);
		}
		
		return listOfListInventory;
	}
	
	@Transactional
	public void disableInventory(Integer iId) {
		iDAO.disableInventory(iId);
	}
}
