package com.vincentko.taskreminder.object;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="task_reminder")
public class Task {


	@Id
	@Column(name="TASK_ID")
	@GeneratedValue
	public Integer taskId;

	@Column(name="TITLE")
	private String title;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="pubDate")
	private Calendar pubDate;
	
	@Column(name="effectiveDate")
	private Calendar effectiveDate;
	
	public Task() {
	}
	
	public Task(Integer taskId, String title, String description,
			Calendar pubDate, Calendar effectiveDate) {
		super();
		this.taskId = taskId;
		this.title = title;
		this.description = description;
		this.pubDate = pubDate;
		this.effectiveDate=effectiveDate;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getPubDate() {
		return pubDate;
	}

	public void setPubDate(Calendar pubDate) {
		this.pubDate = pubDate;
	}

	public Calendar getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Calendar effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

}


