package com.vincentko.financialstatement.dao;

import java.util.List;

import com.vincentko.financialstatement.object.PayCheck;

public interface FinancialStatementDAO {
	
	public List<PayCheck> listPayCheck();
	public void addPayCheck(PayCheck payCheck);

}



