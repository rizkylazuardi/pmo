/**
 * 
 */
package com.anabatic.usm.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : agung.kurniawan
 * @since : 22 Jan 2016
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorizationField {

	/**
	 * Set message key for field that is shown on the page. If it not set will use field name to be shown.
	 */
	String messageKey() default "";
	
	/**
	 * Decide the field is shown or not, default is true
	 */
	boolean shown() default true;
	
	/**
	 * Manage the sequential order of displayed fields
	 */
	int order() default 0;
	
	/**
	 * Include field in reference object to show on authorize page. If it not declared, authorize page will be show only Id
	 */
	String[] referenceFields() default {};
	
}
