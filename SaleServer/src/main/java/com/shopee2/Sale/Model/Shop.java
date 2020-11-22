package com.shopee2.Sale.Model;

import org.springframework.stereotype.Component;

@Component
public class Shop {
	
	private int id;
	private int ownerId;
	private String picture;
	private String name;
	private String detail;
	private String shopType;
	private int follower;
	private double rating;
	private String address;
	private String phoneNumber;
	
	public Shop() {
		super();
	}
	
	public Shop(int id, int ownerId, String picture, String name, String detail, String shopType, int follower,
			double rating, String address, String phoneNumber) {
		super();
		this.id = id;
		this.ownerId = ownerId;
		this.picture = picture;
		this.name = name;
		this.detail = detail;
		this.shopType = shopType;
		this.follower = follower;
		this.rating = rating;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getShopType() {
		return shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	public int getFollower() {
		return follower;
	}

	public void setFollower(int follower) {
		this.follower = follower;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
