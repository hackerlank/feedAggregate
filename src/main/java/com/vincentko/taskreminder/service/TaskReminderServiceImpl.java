package com.vincentko.taskreminder.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vincentko.taskreminder.dao.TaskReminderDAO;
import com.vincentko.taskreminder.object.Task;

@Service
public class TaskReminderServiceImpl implements TaskReminderService {

	@Autowired
	private TaskReminderDAO trDAO;

	@Transactional
	public List<Task> listTask() {

		return trDAO.listTask();
	}
	
	@Transactional
	public List<Task> listReminderEvent() {
		
		return trDAO.listReminderEvent();		
	}
	
	@Transactional
	public List<Task> listEffectiveEvent() {
		
		return trDAO.listEffectiveEvent();		
	}
	
	@Transactional
	public void addTask(Task task) {
		trDAO.addTask(task);
	}

	@Transactional
	public void removeTask(Integer id) {
		trDAO.removeTask(id);
	}
	
}
