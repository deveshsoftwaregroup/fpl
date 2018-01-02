package com.sportmgmt.vendor.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="V_ARTICLE")
public class V_Article {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="ARTICLE_ID")
	private Integer article_id;
	
	@Column(name="VENDOR_ID")
	private Integer vendor_id;
	
	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

	public Integer getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(Integer vendor_id) {
		this.vendor_id = vendor_id;
	}

	public Integer getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}

	public Integer getPosition_price_id() {
		return position_price_id;
	}

	public void setPosition_price_id(Integer position_price_id) {
		this.position_price_id = position_price_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getPublished_date() {
		return published_date;
	}

	public void setPublished_date(Date published_date) {
		this.published_date = published_date;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Column(name="POSITION_ID")
	private Integer position_id;
	
	@Column(name="POSITION_PRICE_ID")
	private Integer position_price_id;
	
	@Column(name="CATEGORY")
	private String  category;
	
	@Column(name="HEADING")
	private String  heading;
	
	@Column(name="CONTENT")
	private String  content;
	
	@Column(name="LINK")
	private String  link;
	
	@Column(name="PUBLISHED_DATE")
	private Date published_date;
	
	@Column(name="IMAGE_PATH")
	private String  image_path;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	
	

}
