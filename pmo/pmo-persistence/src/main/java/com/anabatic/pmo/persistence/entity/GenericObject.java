/**
 * 
 */
package com.anabatic.pmo.persistence.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.anabatic.pmo.persistence.entity.dto.QueryParamDto;



/**
 * @author muchamad.girinata
 *this class for keep table name, key fieldName
 */
public class GenericObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8430180009872879262L;
	String tableName; 
	String fieldName;
	Object value;
	Boolean isGeneratedValue;
	String status;
	Map<String, QueryParamDto> param = new LinkedHashMap<String, QueryParamDto>();
	
	public Map<String, QueryParamDto> getParam() {
		return param;
	}

	public void setParam(Map<String, QueryParamDto> param) {
		this.param = param;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Boolean getIsGeneratedValue() {
		return isGeneratedValue;
	}

	public void setIsGeneratedValue(Boolean isGeneratedValue) {
		this.isGeneratedValue = isGeneratedValue;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime
				* result
				+ ((isGeneratedValue == null) ? 0 : isGeneratedValue.hashCode());
		result = prime * result + ((param == null) ? 0 : param.hashCode());
		result = prime * result
				+ ((tableName == null) ? 0 : tableName.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericObject other = (GenericObject) obj;
		if (fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!fieldName.equals(other.fieldName))
			return false;
		if (isGeneratedValue == null) {
			if (other.isGeneratedValue != null)
				return false;
		} else if (!isGeneratedValue.equals(other.isGeneratedValue))
			return false;
		if (param == null) {
			if (other.param != null)
				return false;
		} else if (!param.equals(other.param))
			return false;
		if (tableName == null) {
			if (other.tableName != null)
				return false;
		} else if (!tableName.equals(other.tableName))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GenericObject [tableName=" + tableName + ", fieldName="
				+ fieldName + ", value=" + value + ", isGeneratedValue="
				+ isGeneratedValue + ", param=" + param + "]";
	}
	
}
