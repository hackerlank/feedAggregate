package com.vincentko.financialstatement.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vincentko.financialstatement.object.PayCheck;
import com.vincentko.financialstatement.service.FinancialStatementService;

@Controller
public class FinancialStatement {

//  @RequestMapping(value="/index",method=RequestMethod.GET)
//  public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
//    
//    return new ModelAndView("home");
//  }

	@Autowired private FinancialStatementService fsService;

	
	@RequestMapping("/paycheck")
	public String listPayCheck(Map<String, Object> map) {
		
		List<PayCheck> list =fsService.listPayCheck();
		BigDecimal salary = new BigDecimal(0);
		BigDecimal netPay = new BigDecimal(0);
		BigDecimal taxes = new BigDecimal(0);
		BigDecimal ferderalWithhold = new BigDecimal(0);
		BigDecimal socialSecurity = new BigDecimal(0);
		BigDecimal medicare = new BigDecimal(0);
		BigDecimal stateWithhold = new BigDecimal(0);
		BigDecimal deduction = new BigDecimal(0);	
		
		for (PayCheck paycheck : list) {
			netPay=netPay.add(paycheck.getNetPay());
			salary=salary.add(paycheck.getSalary());
			taxes=taxes.add(paycheck.getTaxes());
			ferderalWithhold=ferderalWithhold.add(paycheck.getFerderalWithhold());
			socialSecurity=socialSecurity.add(paycheck.getSocialSecurity());
			medicare=medicare.add(paycheck.getMedicare());
			stateWithhold=stateWithhold.add(paycheck.getStateWithhold());
			deduction=deduction.add(paycheck.getDeduction());
		}
		
		map.put("payCheck", new PayCheck());
		map.put("payCheckList", fsService.listPayCheck());	//All Paychecks
		map.put("netPay", netPay);
		map.put("salary", salary);
		map.put("taxes", taxes);
		map.put("ferderalWithhold", ferderalWithhold);
		map.put("socialSecurity", socialSecurity);
		map.put("medicare", medicare);
		map.put("stateWithhold", stateWithhold);
		map.put("deduction", deduction);
		
		return "financial_statement";
	}
	
	
	@RequestMapping(value = "/addpaycheck", method = RequestMethod.POST)
	public String addPayCheck(@ModelAttribute("paycheck")
	PayCheck paycheck, BindingResult result) {

		paycheck.setPubDate(Calendar.getInstance());
		paycheck.setTaxes(paycheck.getFerderalWithhold().add(paycheck.getSocialSecurity().add(paycheck.getMedicare().add(paycheck.getStateWithhold()))));
		paycheck.setNetPay(paycheck.getSalary().subtract(paycheck.getTaxes().add(paycheck.getDeduction())));
		fsService.addPayCheck(paycheck);
		
		return "redirect:/paycheck.html";
	}
	
	@RequestMapping("/newpaycheck")
	public String newPayCheck(Map<String, Object> map) {
		
		int payCheckNew = 1;
		
		map.put("payCheckNew", payCheckNew);
		map.put("paycheck", new PayCheck());
		
		return "financial_statement";
	}	

}