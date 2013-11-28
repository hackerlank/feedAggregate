package com.vincentko.inventory.controller;

import java.util.ArrayList;
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
import com.vincentko.inventory.object.Inventory;
import com.vincentko.inventory.object.InventoryCategory;
import com.vincentko.inventory.object.InventoryCategoryLink;
import com.vincentko.inventory.service.InventoryService;
import com.vincentko.taskreminder.object.Task;
import com.vincentko.vocabulary.object.Vocabulary;
import com.vincentko.vocabulary.object.VocabularyCategory;
import com.vincentko.vocabulary.service.VocabularyService;

@Controller
public class InventoryController {

//  @RequestMapping(value="/index",method=RequestMethod.GET)
//  public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
//    
//    return new ModelAndView("home");
//  }

	@Autowired private InventoryService iService;
	
	
	@RequestMapping("/inventory")
	public String listVocabulary(Map<String, Object> map) {

		map.put("icl", new InventoryCategoryLink());
		map.put("iclList", new ArrayList<InventoryCategoryLink>());
		map.put("iclListOfList", iService.prepareInventoryByCategory());

		return "inventory";
	}
	

	@RequestMapping(value = "/addinventory", method = RequestMethod.POST)
	public String addInventory(@ModelAttribute("inventory")
	Inventory inventory, @RequestParam("catId") Integer catId) {
		
		InventoryCategory ic = iService.getInventoryCategoryById(catId);
		
		inventory.setImportDate(Calendar.getInstance());
		inventory.setItemDisable(0);
		
		iService.addInventory(inventory);
						
		InventoryCategoryLink icl = new InventoryCategoryLink();
		icl.setInventory(inventory);
		icl.setInventoryCategory(ic);
		iService.addInventoryCategoryLink(icl);
		
		return "redirect:/inventory.html";
	}

	
	@RequestMapping("/newinventory")
	public String newInventory(Map<String, Object> map) {
		
		map.put("inventory", new Inventory());
		map.put("category", new InventoryCategory());
		map.put("catList", iService.listInventoryCategory());	//All Categories
		return "inventory_new";
	}
	
	@RequestMapping("/editinventory/{itemId}/edit")
	public String editInventory(@PathVariable("itemId") Integer itemId, Map<String, Object> map) {
		
		map.put("inventory", iService.getInventoryById(itemId));
		System.out.println(iService.getInventoryById(itemId).getItemName());
		map.put("category", new InventoryCategory());
		map.put("catList", iService.listInventoryCategory());	//All Categories
		return "inventory_edit";
	}	
	
	@RequestMapping(value = "/editinventory/{itemId}/editinventory", method = RequestMethod.POST)
	public String editAddInventory(@ModelAttribute("inventory")
	Inventory inventory, @RequestParam("catId") Integer catId, @RequestParam("itemId") Integer itemId) {
	
		
		inventory.setItemId(itemId);
		inventory.setImportDate(Calendar.getInstance());
		inventory.setItemDisable(0);
		
		iService.addInventory(inventory);

		return "redirect:/inventory.html";
	}
	
	@RequestMapping(value = "/addinventorycategory", method = RequestMethod.POST)
	public String addInventoryCategory(@ModelAttribute("category")
	InventoryCategory inventoryCategory, BindingResult result) {

		iService.addInventoryCategory(inventoryCategory);

		return "redirect:/inventory.html";
	}

	
	@RequestMapping("/newinventorycategory")
	public String newInventoryCategory(Map<String, Object> map) {
		
		map.put("category", new InventoryCategory());
		return "inventory_category_new";
	}
	
    @RequestMapping(value="/disableinventory", method = RequestMethod.POST)
    public String disableInventory(@RequestParam("iId") Integer iId, Model model) {
    
    	iService.disableInventory(iId);
		
    	return "redirect:/inventory.html";
    }
}