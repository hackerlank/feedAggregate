package com.vincentko.feedaggregate.object;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="FEED_CHANNEL")
public class FeedChannel {

	@Id
	@Column(name="CHANNEL_ID")
	@GeneratedValue
	private Integer channelId;
	
	@Column(name="CHANNEL_NAME")
	private String channelName;	
	
    @OneToMany(cascade = {CascadeType.ALL})
    private List<FeedCategory> feedCategory;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Feed> feed;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Article> article;

	public FeedChannel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FeedChannel(Integer channelId, String channelName,
			List<FeedCategory> feedCategory, List<Feed> feed) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.feedCategory = feedCategory;
		this.feed = feed;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public List<FeedCategory> getFeedCategory() {
		return feedCategory;
	}

	public void setFeedCategory(List<FeedCategory> feedCategory) {
		this.feedCategory = feedCategory;
	}

	public List<Feed> getFeed() {
		return feed;
	}

	public void setFeed(List<Feed> feed) {
		this.feed = feed;
	}
    
	
}
