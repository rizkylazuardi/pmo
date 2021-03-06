package com.anabatic.pmo.persistence.entity;

import com.anabatic.pmo.persistence.annotation.IdentityAnnotation;
import com.anabatic.pmo.persistence.annotation.TableAnnotation;



@TableAnnotation(tableName="core_employee_group")
public class EmployeeGroup extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5271877254393764643L;
	private Long id;
	private String name;
	private String description;
	private String descriptionEn;
	
	@IdentityAnnotation(isGenerateValue=false,fieldName="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescriptionEn() {
		return descriptionEn;
	}
	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}
	@Override
	public String toString() {
		return "EmployeeGroup [id=" + id + ", name=" + name + ", description="
				+ description + ", descriptionEn=" + descriptionEn + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((descriptionEn == null) ? 0 : descriptionEn.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeGroup other = (EmployeeGroup) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (descriptionEn == null) {
			if (other.descriptionEn != null)
				return false;
		} else if (!descriptionEn.equals(other.descriptionEn))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
				
}
