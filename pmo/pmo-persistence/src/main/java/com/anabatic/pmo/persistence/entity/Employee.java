package com.anabatic.pmo.persistence.entity;


public class Employee extends BaseModel{
	
	private static final long serialVersionUID = 571233452306262158L;
	private Long id;
	private String nik;
	private String title;
	public String group;
	
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


	public String getGroup() {
		return group;
	}


	public void setGroup(String group) {
		this.group = group;
	}

}
