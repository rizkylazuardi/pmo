package com.anabatic.pmo.businesslogic.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anabatic.pmo.businesslogic.validator.BaseValidator;
import com.anabatic.pmo.businesslogic.validator.api.IEmployeeGroupValidator;
import com.anabatic.pmo.core.enumeration.ErrorCodeEnum;
import com.anabatic.pmo.core.util.ErrorCode;
import com.anabatic.pmo.persistence.entity.EmployeeGroup;
import com.anabatic.pmo.service.api.EmployeeGroupService;

@Component
public class EmployeeGroupValidatorImpl extends BaseValidator<EmployeeGroup> implements IEmployeeGroupValidator{

	@Autowired
	EmployeeGroupService service;
	
	@Override
	protected void validateObject(EmployeeGroup object) {
		EmployeeGroup emp = service.getByName(object);
		if(emp!=null){
			error.put("name", new ErrorCode(ErrorCodeEnum.GROUPNAME_USED.getCode(), 
					ErrorCodeEnum.GROUPNAME_USED.getDefaultMsg()));
		}
	}

	@Override
	public void validateEdit(EmployeeGroup param) {
		EmployeeGroup emp = service.getById(param);
		if( emp != null){
			EmployeeGroup emp2 = service.getByName(param);
			if(emp2 != null && emp2.getName().equalsIgnoreCase(param.getName()) && !param.getName().equalsIgnoreCase(emp.getName())){
				error.put("name", new ErrorCode(ErrorCodeEnum.GROUPNAME_USED.getCode(), 
						ErrorCodeEnum.GROUPNAME_USED.getDefaultMsg()));
			}
		}else{
			error.put("id", new ErrorCode(ErrorCodeEnum.DATA_NOT_FOUND.getCode(), 
					ErrorCodeEnum.DATA_NOT_FOUND.getDefaultMsg()));
		}
	}

}
