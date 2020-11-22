package com.shopee2.Sale.Model;

import org.springframework.stereotype.Component;

@Component
public class CommentProduct {

	private int id;
	private int productId;
	private int user;
	private String detail;
	private int rating;
	
	public CommentProduct() {
		super();
	}

	public CommentProduct(int id, int productId, int user, String detail, int rating) {
		super();
		this.id = id;
		this.productId = productId;
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

	public int getProductId() {
		return productId;
	}

	public void setProduct(int productId) {
		this.productId = productId;
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
