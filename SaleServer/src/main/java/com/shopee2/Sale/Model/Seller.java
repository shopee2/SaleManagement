package com.shopee2.Sale.Model;

import org.springframework.stereotype.Component;

@Component
public class Seller {

	private int sid;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private String phoneNumber;
	private String picture;
	
	public Seller() {
		super();
	}
	
	public Seller(int sid, String firstname, String lastname, String email,
			String address, String phoneNumber, String picture) {
		super();
		this.sid = sid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.picture = picture;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	
}
