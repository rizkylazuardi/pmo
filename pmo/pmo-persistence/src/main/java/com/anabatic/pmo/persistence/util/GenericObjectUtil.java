/**
 * 
 */
package com.anabatic.pmo.persistence.util;

import java.lang.reflect.Method;





import java.util.Date;

import com.anabatic.pmo.core.enumeration.DataStatusEnum;
import com.anabatic.pmo.persistence.annotation.IdentityAnnotation;
import com.anabatic.pmo.persistence.annotation.TableAnnotation;
import com.anabatic.pmo.persistence.entity.EmployeeGroup;
import com.anabatic.pmo.persistence.entity.GenericObject;


/**
 * @author muchamad.girinata
 *
 */
public class GenericObjectUtil {

	
	public static Object setGenericObjectValue(Object param,Boolean isDelete) throws Exception{
		GenericObject genericObject = (GenericObject) param;
		genericObject.setStatus(DataStatusEnum.HIST.name());
		return setGenericObjectValue(genericObject);
	}
	
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
