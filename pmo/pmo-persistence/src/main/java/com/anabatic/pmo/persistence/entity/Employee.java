package com.anabatic.pmo.persistence.entity;

import com.anabatic.pmo.persistence.annotation.TableAnnotation;

@TableAnnotation(tableName = "core_employee")
public class Employee extends BaseModel {

	private static final long serialVersionUID = 571233452306262158L;
	private Long id;
	private String nik;
	private String title;
	public String grupId;
	public String city;
	public String postal_code;
	public String province;
	public String street_adress1;
	public String street_adress2;
	public String nickname;
	public String username;
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public String getGrupId() {
		return grupId;
	}

	public void setGrupId(String grupId) {
		this.grupId = grupId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getStreet_adress1() {
		return street_adress1;
	}

	public void setStreet_adress1(String street_adress1) {
		this.street_adress1 = street_adress1;
	}

	public String getStreet_adress2() {
		return street_adress2;
	}

	public void setStreet_adress2(String street_adress2) {
		this.street_adress2 = street_adress2;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


}
