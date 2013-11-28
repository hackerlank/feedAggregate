package com.vincentko.taskreminder.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.List;

import com.vincentko.api.VincentKoUtil;
import com.vincentko.taskreminder.object.Task;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskReminderDAOImpl implements TaskReminderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Task> listTask() {
		String sql= "from Task tr " +
					"ORDER BY tr.pubDate DESC";
		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery(sql);
		
		List<Task> list= qry.setMaxResults(100).list();

		return list;
	}

	public List<Task> listReminderEvent() {
		VincentKoUtil util = new VincentKoUtil();
		Calendar c = util.dateAdd(1);
		Calendar eDate = Calendar.getInstance();
		Date dateReminder= c.getTime();
				
		String sql= "from Task tr " +
					"WHERE tr.effectiveDate IS NOT NULL " +
					"ORDER BY tr.pubDate DESC";
		
		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery(sql);

		List<Task> list= qry.setMaxResults(100).list();
		List<Task> listSelected = new ArrayList<Task>();
		
		for(Task row: list) {
			eDate = row.getEffectiveDate();
			util.setBeginningOfDay(eDate);
			if(c.equals(eDate)) {
				listSelected.add(row);
			}			
		}
		
		return listSelected;
	}
	
	public List<Task> listEffectiveEvent() {
		
		VincentKoUtil util = new VincentKoUtil();
		Calendar c = util.dateAdd(0);
		Calendar eDate = Calendar.getInstance();
		Date dateReminder= c.getTime();
				
		String sql= "from Task tr " +
					"WHERE tr.effectiveDate IS NOT NULL " +
					"ORDER BY tr.pubDate DESC";
		
		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery(sql);

		List<Task> list= qry.setMaxResults(100).list();
		List<Task> listSelected = new ArrayList<Task>();
		
		for(Task row: list) {
			eDate = row.getEffectiveDate();
			util.setBeginningOfDay(eDate);
			if(c.equals(eDate)) {
				listSelected.add(row);
			}			
		}
		
		return listSelected;
	}
	
	public void addTask(Task task) {
		sessionFactory.getCurrentSession().save(task);
	}
	
	public void removeTask(Integer id) {
		Task task = (Task) sessionFactory.getCurrentSession().load(
				Task.class, id);
		if (null != task) {
			sessionFactory.getCurrentSession().delete(task);
		}

	}
}