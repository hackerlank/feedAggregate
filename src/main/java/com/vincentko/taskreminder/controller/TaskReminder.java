package com.vincentko.taskreminder.controller;

import java.text.ParseException;
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

import com.vincentko.api.VincentKoUtil;
import com.vincentko.taskreminder.object.Task;
import com.vincentko.taskreminder.service.TaskReminderService;

@Controller
public class TaskReminder {

//  @RequestMapping(value="/index",method=RequestMethod.GET)
//  public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
//    
//    return new ModelAndView("home");
//  }

	@Autowired private TaskReminderService taskService;
	
	
	@RequestMapping("/taskreminder")
	public String listTasks(Map<String, Object> map) {

		map.put("task", new Task());
		map.put("taskList", taskService.listTask());	//All Tasks
		return "task_reminder";
	}
	
	@RequestMapping("/checklist")
	public String checkList(Map<String, Object> map) {

		return "checklist";
	}
	
	@RequestMapping(value = "/addtask", method = RequestMethod.POST)
	public String addTask(@ModelAttribute("task")
	Task task,  @RequestParam("eDate") String eDate) throws ParseException {
		VincentKoUtil util = new VincentKoUtil();
		task.setPubDate(Calendar.getInstance());
		
		Calendar c = Calendar.getInstance();
		c.setTime(util.convertStringToDate(eDate));
		task.setEffectiveDate(c);
		
		taskService.addTask(task);

		return "redirect:/taskreminder.html";
	}


/*		@RequestMapping("/deletetask/{taskId}")
		public String deleteTask(@PathVariable("taskId")
		Integer taskId) {
	
			taskService.removeTask(taskId);
	
			return "redirect:/taskreminder.html";
		}*/
		
		
		
	    @RequestMapping(value="/deletetask", method = RequestMethod.POST)
	    public String deleteTask(@ModelAttribute("task") Task task,BindingResult result, @RequestParam("taskId") Integer taskId, Model model) {
	    
			taskService.removeTask(taskId);
			
			return "redirect:/taskreminder.html";
	    }
	    
	
}