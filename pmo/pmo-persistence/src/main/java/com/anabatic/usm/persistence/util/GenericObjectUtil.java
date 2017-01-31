/**
 * 
 */
package com.anabatic.usm.persistence.util;

import java.lang.reflect.Method;



import com.anabatic.usm.persistence.annotation.IdentityAnnotation;
import com.anabatic.usm.persistence.annotation.TableAnnotation;
import com.anabatic.usm.persistence.entity.GenericObject;


/**
 * @author muchamad.girinata
 *
 */
public class GenericObjectUtil {
	public static Object setGenericObjectValue(Object param) throws Exception{
		if(param instanceof GenericObject){
			GenericObject genericObject = (GenericObject) param;
			Class genericClass = genericObject.getClass();
			TableAnnotation tableAnnotation = (TableAnnotation) genericClass.getAnnotation(TableAnnotation.class);
			genericObject.setTableName(tableAnnotation.tableName());
			if(genericObject.getParam().size()==0){
				for(Method method : genericClass.getMethods()){
					IdentityAnnotation identityAnnotation = method.getAnnotation(IdentityAnnotation.class);
					if(identityAnnotation!=null){
						Object value = method.invoke(genericObject, null);
						genericObject.setFieldName(identityAnnotation.fieldName());
						genericObject.setValue(value);
						genericObject.setIsGeneratedValue(identityAnnotation.isGenerateValue());
						break;	
					}
				}
			}
			return genericObject;
		}else{
			throw new Exception("paramter false");
		}
	}
}
