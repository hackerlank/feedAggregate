package com.vincentko.financialstatement.dao;

import java.util.List;

import com.vincentko.financialstatement.object.PayCheck;
import com.vincentko.taskreminder.object.Task;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FinancialStatementDAOImpl implements FinancialStatementDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<PayCheck> listPayCheck() {
		String sql= "from PayCheck pc " +
					"ORDER BY pc.pubDate DESC";
		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery(sql);
		
		List<PayCheck> list= qry.setMaxResults(1000).list();

		return list;
	}
	
	public void addPayCheck(PayCheck payCheck) {
		sessionFactory.getCurrentSession().save(payCheck);
	}

}