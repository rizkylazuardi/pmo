/**
 * 
 */
package com.anabatic.pmo.businesslogic.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.anabatic.pmo.core.util.ErrorCode;



/**
 * @author ahlul.esasjana
 * from BaseValidator Pocket Core
 *
 */
public abstract class BaseValidator<T> implements IValidator<T> {
	protected Map<String, ErrorCode> error = new HashMap<String, ErrorCode>();

	protected static final Logger log = Logger.getLogger(BaseValidator.class);


	@Override
	public void validate(T object) {
		error.clear();
		validateObject(object);
	}

	public boolean hasError() {
		if(error.isEmpty()) return false;
		return true;
	}
	
	public Map<String, ErrorCode> getErrors() {
		return error;
	}
	
	public boolean validateCode(String input){
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\-]+$");
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
	
	public boolean isNumberOnly(String input){
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
	
	public boolean validatePhoneNumber(String input){
		//validate phone numbers of format "1234567890"
		if (input.matches("\\d{10}")) return true;
		//validating phone number with -, . or spaces
		else if(input.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
		//validating phone number with extension length from 3 to 5
		else if(input.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
		//validating phone number where area code is in braces ()
		else if(input.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
		//return false if nothing matches the input
		else return false;
	}
	
	public boolean isAlphabetOnly(String input){
		Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z ]+$");
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
	
	public boolean isAlphanumeric(String input){
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9 ]+$");
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
	
	public boolean validateRegex(String input, String regex){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
	
	protected abstract void validateObject(T object);
	
}
