package com.vincentko.financialstatement.service;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vincentko.financialstatement.dao.FinancialStatementDAO;
import com.vincentko.financialstatement.object.PayCheck;
import com.vincentko.taskreminder.dao.TaskReminderDAO;
import com.vincentko.taskreminder.object.Task;

@Service
public class FinancialStatementServiceImpl implements FinancialStatementService {

	@Autowired
	private FinancialStatementDAO fsDAO;

	@Transactional
	public List<PayCheck> listPayCheck() {

		return fsDAO.listPayCheck();
	}
	
	@Transactional
	public void addPayCheck(PayCheck payCheck) {
		fsDAO.addPayCheck(payCheck);
	}

	
}
