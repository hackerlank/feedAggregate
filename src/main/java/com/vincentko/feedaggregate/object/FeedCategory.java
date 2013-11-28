package com.vincentko.feedaggregate.object;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;


@Entity
@Table(name="FEED_CATEGORY")
public class FeedCategory {
	
	@Id
	@Column(name="CATEGORY_ID")
	@GeneratedValue
	private Integer categoryId;

	@Column(name="category_name")
	private String categoryName;

    @ManyToOne
    @JoinColumn(name="channel_id")
	private FeedChannel feedChannel;

	@Column(name="file_name")
	private String fileName;	
	
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Feed> feed;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Article> article;

	public FeedCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedCategory(Integer categoryId, String categoryName,
			FeedChannel feedChannel, String fileName, List<Feed> feed) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.feedChannel = feedChannel;
		this.fileName = fileName;
		this.feed = feed;
	}
	
	public FeedCategory(Integer categoryId, String categoryName,
			FeedChannel feedChannel) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.feedChannel = feedChannel;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public FeedChannel getFeedChannel() {
		return feedChannel;
	}

	public void setFeedChannel(FeedChannel feedChannel) {
		this.feedChannel = feedChannel;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<Feed> getFeed() {
		return feed;
	}

	public void setFeed(List<Feed> feed) {
		this.feed = feed;
	}



	
    
}
