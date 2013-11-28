package com.vincentko.financialstatement.service;

import java.util.List;

import com.vincentko.financialstatement.object.PayCheck;

public interface FinancialStatementService {
	
	public List<PayCheck> listPayCheck();
	public void addPayCheck(PayCheck payCheck);

}
