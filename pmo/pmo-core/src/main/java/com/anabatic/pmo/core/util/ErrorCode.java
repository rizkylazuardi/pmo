/**
 * 
 */
package com.anabatic.pmo.core.util;

import java.io.Serializable;

/**
 * @author ahlul.esasjana
 * from ErrorCode Pocket Core
 */
public class ErrorCode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8241989547693162858L;
	
	private String code;
	private String key;
	private String defaultMessage;

	public ErrorCode() {
		super();
	}

	public ErrorCode(String code, String defaultMessage) {
		super();
		this.code = code;
		this.defaultMessage = defaultMessage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

}
