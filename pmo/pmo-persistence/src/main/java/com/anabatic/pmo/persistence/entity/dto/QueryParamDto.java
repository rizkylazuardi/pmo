/**
 * 
 */
package com.anabatic.pmo.persistence.entity.dto;

/**
 * @author muchamad.girinata
 *this class for query parameter
 */
public class QueryParamDto {
	
	public QueryParamDto(String operator, Object value, String andOr) {
		super();
		this.operator = operator;
		this.value = value;
		this.andOr = andOr;
	}

	private String operator;
	private Object value;
	private String andOr;
	
	public String getAndOr() {
		return andOr;
	}

	public void setAndOr(String andOr) {
		this.andOr = andOr;
	}

	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

}
