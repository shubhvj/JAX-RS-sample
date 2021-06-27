package com.shubh.hyperactivebeing.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	
	private long id;
	private String pName;
	private String fName;
	private String lName;
	private Date created;
	
	public Profile() {
		
	}
	
	public Profile(long id, String pName, String fName, String lName) {
		this.id = id;
		this.pName = pName;
		this.fName = fName;
		this.lName = lName;
		this.created = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
