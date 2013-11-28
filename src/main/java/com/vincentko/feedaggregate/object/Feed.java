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
@Table(name="FEED")
public class Feed {

	@Id
	@Column(name="ITEM_ID")
	@GeneratedValue
	private Integer itemId;

	@Column(name="TITLE")
	private String title;
	
	@Column(name="GUID")
	private String guid;
	
	@Column(name="LINK")
	private String link;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="pubDate")
	private String pubDate;
	
	@Column(name="pubDate_converted")
	private Calendar pubDateConverted;
		
    @ManyToOne
    @JoinColumn(name="channel_id")
	private FeedChannel feedChannel;
    
    @ManyToOne
    @JoinColumn(name="category_id")
	private FeedCategory feedCategory;

	@Column(name="feed_is_favorite")
	private Integer feedIsFavorite;
	
	public Feed() {
	}
	


	
	public Feed(FeedChannel fch, FeedCategory fca, Integer itemId, String title, String description, String guid, Calendar pubDateConverted) {
		this.feedChannel = fch;
		this.feedCategory = fca;
		this.itemId = itemId;
		this.title = title;
		this.description = description;
		this.guid = guid;
		this.pubDateConverted = pubDateConverted;
	}




	public Feed(Integer itemId, String title, String guid, String link,
			String description, String pubDate, Calendar pubDateConverted,
			FeedChannel feedChannel, FeedCategory feedCategory) {
		super();
		this.itemId = itemId;
		this.title = title;
		this.guid = guid;
		this.link = link;
		this.description = description;
		this.pubDate = pubDate;
		this.pubDateConverted = pubDateConverted;
		this.feedChannel = feedChannel;
		this.feedCategory = feedCategory;
	}



	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public Calendar getPubDateConverted() {
		return this.pubDateConverted;
	}

	public void setPubDateConverted(Calendar pubDateConverted) {
		this.pubDateConverted = pubDateConverted;
	}

	public FeedChannel getFeedChannel() {
		return this.feedChannel;
	}

	public void setFeedChannel(FeedChannel feedChannel) {
		this.feedChannel = feedChannel;
	}

	public FeedCategory getFeedCategory() {
		return this.feedCategory;
	}

	public void setFeedCategory(FeedCategory feedCategory) {
		this.feedCategory = feedCategory;
	}




	public Integer getFeedIsFavorite() {
		return feedIsFavorite;
	}




	public void setFeedIsFavorite(Integer feedIsFavorite) {
		this.feedIsFavorite = feedIsFavorite;
	}

}
