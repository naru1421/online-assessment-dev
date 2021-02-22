package com.tonline.dto;

import java.util.Date;


public class Customer {

	private  long id;
	private  String name;
	private  String status;
	private String emailId;

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setLastLoggedIn(Date lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}

	private  Date lastLoggedIn;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getLastLoggedIn() {
		return lastLoggedIn;
	}
}
