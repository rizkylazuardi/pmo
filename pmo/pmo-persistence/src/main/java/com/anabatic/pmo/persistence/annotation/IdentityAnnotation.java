/**
 * annotation
 */
package com.anabatic.pmo.persistence.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author muchamad.girinata
 *
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface IdentityAnnotation {
	boolean isGenerateValue() default false;
	String fieldName() default "";
	String joinFieldName() default "";
}
