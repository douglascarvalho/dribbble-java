package com.douglas.carvalho.dribbblejava.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "screenshot")
public class Screenshot {
	
	@Id
	private Long id;
	
	@Column
	private String title;
	
	@SerializedName("user")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "screenshot_author_id")
	private Author author;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Image images;
	
	@Column
	@SerializedName("created_at")
	private String publishDate;
	
	@Column
	@SerializedName("views_count")
	private Integer viewsCount;
	
	@Column
	@SerializedName("likes_count")
	private Integer likesCount;
	
	@Column
	@SerializedName("buckets_count")
	private Integer bucketsCount;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
