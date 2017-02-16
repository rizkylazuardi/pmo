package com.anabatic.pmo.core.enumeration;

public enum DataStatusEnum {
		LIVE						("LIVE", "LIVE"),
		INAU						("INAU", "INAU"),
		DELAU						("DELAU", "DELAU"),
		HIST						("HIST", "HIST"),
		REJECT						("REJECT", "REJECT");
		
	private String code;
	private String defaultMsg;
	
	private DataStatusEnum(String code, String defaultMsg) {
		this.code = code;
		this.defaultMsg = defaultMsg;
	}

	public final String getCode() {
		return code;
	}

	public String getDefaultMsg() {
		return defaultMsg;
	}

	public void setDefaultMsg(final String defaultMsg) {
		this.defaultMsg = defaultMsg;
	}
	
	public String getFullMsg(){
		return code + " : " + defaultMsg;
	}
}
