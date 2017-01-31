/**
 * 
 */
package com.anabatic.usm.core.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author agung.kurniawan
 * Date Jun 10, 2013
 */
public enum SecurityQuestionEnum {
	
	QUESTION_SISTER_NAME(1, "1. What is your sister first name?"), 
	QUESTION_PET(2, "2. What is your first pet?"), 
	QUESTION_FIRST_SCHOOL(3, "3. Where is your first school?"),
	QUESTION_BORN_PLACE(4, "4. Where are you born?");
	
	private int statusValue;
	private String statusType;
	
	private static final Map<Integer, SecurityQuestionEnum> lookup = new HashMap<Integer, SecurityQuestionEnum>();
	static {
	       for (SecurityQuestionEnum d : SecurityQuestionEnum.values())
	            lookup.put(d.getAccessValue(), d);
	}
	
	public static SecurityQuestionEnum get(Integer value) {
	        return lookup.get(value);
	}
	
	private SecurityQuestionEnum(int statusValue, String statusType) {
		this.statusType = statusType;
		this.statusValue = statusValue;
	}

	public String getAccessType() {
		return statusType;
	}

	public int getAccessValue() {
		return statusValue;
	}

}
