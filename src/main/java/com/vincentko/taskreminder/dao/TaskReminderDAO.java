package com.vincentko.taskreminder.dao;

import java.util.List;

import com.vincentko.taskreminder.object.Task;

public interface TaskReminderDAO {
	
	public List<Task> listTask();
	public List<Task> listReminderEvent();
	public List<Task> listEffectiveEvent();
	public void addTask(Task task);
	public void removeTask(Integer id);
}



