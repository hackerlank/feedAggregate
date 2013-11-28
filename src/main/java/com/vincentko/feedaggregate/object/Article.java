package com.vincentko.feedaggregate.object;

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
@Table(name="article")
public class Article {

	@Id
	@Column(name="article_id")
	@GeneratedValue
	public Integer articleId;

	@Column(name="TITLE")
	private String title;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="pubDate")
	private Calendar pubDate;
	
    @ManyToOne
    @JoinColumn(name="channel_id")
	private FeedChannel feedChannel;
    
    @ManyToOne
    @JoinColumn(name="category_id")
	private FeedCategory feedCategory;



	public Article() {
	}

	public Article(Integer articleId, String title, String description,
			Calendar pubDate, FeedChannel feedChannel, FeedCategory feedCategory) {
		super();
		this.articleId = articleId;
		this.title = title;
		this.description = description;
		this.pubDate = pubDate;
		this.feedChannel = feedChannel;
		this.feedCategory = feedCategory;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
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

	public FeedChannel getFeedChannel() {
		return feedChannel;
	}

	public void setFeedChannel(FeedChannel feedChannel) {
		this.feedChannel = feedChannel;
	}

	public FeedCategory getFeedCategory() {
		return feedCategory;
	}

	public void setFeedCategory(FeedCategory feedCategory) {
		this.feedCategory = feedCategory;
	}
}


	
