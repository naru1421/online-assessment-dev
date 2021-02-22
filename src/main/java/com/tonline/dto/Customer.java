package com.tonline.dto;

import java.util.Date;


public class Customer {

	private  long id;
	private  String name;
	private boolean status;
	private String emailId;

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}



	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	}
