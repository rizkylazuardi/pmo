package com.anabatic.pmo.persistence.entity;

import com.anabatic.usm.persistence.entity.CoreUser;


public class Employee extends CoreUser{
	
	private static final long serialVersionUID = 571233452306262158L;
	private Long id;
	private String nik;
	private String title;
	public Long groupId;
	
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}


	public String getNik() {
		return nik;
	}


	public void setNik(String nik) {
		this.nik = nik;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Long getGroupId() {
		return groupId;
	}


	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
}
