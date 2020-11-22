package com.shopee2.Sale.Model;

import org.springframework.stereotype.Component;

@Component
public class CommentShop {
	
	private int id;
	private int shopId;
	private int user;
	private String detail;
	private int rating;
	
	public CommentShop() {
		super();
	}

	public CommentShop(int id, int shopId, int user, String detail, int rating) {
		super();
		this.id = id;
		this.shopId = shopId;
		this.user = user;
		this.detail = detail;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
