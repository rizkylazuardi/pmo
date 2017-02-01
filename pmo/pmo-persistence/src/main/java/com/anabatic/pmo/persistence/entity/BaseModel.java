package com.anabatic.pmo.persistence.entity;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseModel extends GenericObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9011777125481959548L;
	private Date createdTime;
	private String createdBy;
	private Date updatedTime;
	private String updatedBy;
	private String authoriser;
	private Date authorizeTime;
	private String status;
	private Integer version;
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getAuthoriser() {
		return authoriser;
	}
	public void setAuthoriser(String authoriser) {
		this.authoriser = authoriser;
	}
	public Date getAuthorizeTime() {
		return authorizeTime;
	}
	public void setAuthorizeTime(Date authorizeTime) {
		this.authorizeTime = authorizeTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
}
