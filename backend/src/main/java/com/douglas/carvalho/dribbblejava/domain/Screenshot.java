package com.douglas.carvalho.dribbblejava.domain;

import com.google.gson.annotations.SerializedName;

public class Screenshot {
	
	private String title;

	@SerializedName("user")
	private Author author;
	
	@SerializedName("created_at")
	private String publishDate;
	
	private Image images;
	
	@SerializedName("views_count")
	private Integer viewsCount;
	
	@SerializedName("likes_count")
	private Integer likesCount;
	
	@SerializedName("buckets_count")
	private Integer bucketsCount;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Image getImages() {
		return images;
	}

	public void setImages(Image images) {
		this.images = images;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Integer getViewsCount() {
		return viewsCount;
	}

	public void setViewsCount(Integer viewsCount) {
		this.viewsCount = viewsCount;
	}

	public Integer getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(Integer likesCount) {
		this.likesCount = likesCount;
	}

	public Integer getBucketsCount() {
		return bucketsCount;
	}

	public void setBucketsCount(Integer bucketsCount) {
		this.bucketsCount = bucketsCount;
	}
	
}
