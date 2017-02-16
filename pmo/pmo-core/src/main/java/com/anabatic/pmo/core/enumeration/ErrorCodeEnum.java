/**
 * 
 */
package com.anabatic.pmo.core.enumeration;

/**
 * @author ahlul.esasjana
 * from ErrorCodeEnum Pocket Core
 */
public enum ErrorCodeEnum {
	
	/**
	 * ERROR CODE CATEGORIES :
	 * 1000-1099: General Error
	 * 1100-1200: User Operation
	 * 9000-9999: Other
	 */
	
	/**
	 * NOTE :
	 * If you want to add new error code, please give them unique code.
	 * If you want to add new error code categories, please add the error code categories note too.
	 */
	
	// ----------------------------------- GENERAL ERROR CODE : 1000 - 1099 -----------------------------------
		SUCCESS						("1000", "Process successful."),
		PARSING_ERROR				("1001", "Parsing error."),
		INVALID_PARAMETER			("1002", "Invalid parameter."),
		INCOMPLETE_FIELD			("1003", "Missing mandatory field."),
		MALFORMED_MESSAGE			("1004", "Malformed message format."),
		
	
	// --------------------USER OPERATION ERROR CODE : 1100 - 1200 --------------------------
		PASSWORD_NOT_GENERATE		("1100", "Password has not been generated."),
		PASSWORD_NOT_VALID			("1101", "Password is no more valid."),
		PASSWORD_NOT_MATCH			("1102", "Password does not match."),
		EMAIL_USED					("1103", "Email is used, please use another email."),
		PHONE_USED					("1104", "Phone number has already been used"),
		USERNAME_USED				("1105", "Username is used. Please use another username"),
		USERNAME_NOT_FOUND			("1106", "Username not found."),
		OLD_PASSWORD_NOT_VALID		("1107", "Old Password is not valid."),
		USERNAME_NULL				("1108", "Username is required."),
		PASSWORD_NULL				("1109", "Password is required."),
		GROUPNAME_USED				("1110", "Group name is already used, please use another group name."),
		DATA_NOT_FOUND				("1111", "Data Not Found");
	
	private String code;
	private String defaultMsg;
	
	private ErrorCodeEnum(String code, String defaultMsg) {
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
