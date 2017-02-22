package com.anabatic.pmo.businesslogic.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anabatic.pmo.businesslogic.validator.BaseValidator;
import com.anabatic.pmo.businesslogic.validator.api.IEmployeeValidator;
import com.anabatic.pmo.core.enumeration.ErrorCodeEnum;
import com.anabatic.pmo.core.util.ErrorCode;
import com.anabatic.pmo.persistence.entity.Employee;
import com.anabatic.pmo.service.api.EmployeeService;

@Component
public class EmployeeValidatotImpl extends BaseValidator<Employee> implements
		IEmployeeValidator {

	@Autowired
	EmployeeService service;

	@Override
	protected void validateObject(Employee Object) {
		Employee emp = service.getEmployeeByName(Object);
		if (emp != null) {
			error.put("name",
					new ErrorCode(ErrorCodeEnum.GROUPNAME_USED.getCode(),
							ErrorCodeEnum.GROUPNAME_USED.getDefaultMsg()));
		}

	}

	@Override
	public void validateEdit(Employee param) {
		Employee emp = service.getEmployeeById(param);
		if (emp != null) {
			Employee emp2 = service.getEmployeeByName(param);
			if (emp2 != null
					&& emp2.getName().equalsIgnoreCase(param.getName())
					&& !param.getName().equalsIgnoreCase(emp.getName())) {
				error.put("name",
						new ErrorCode(ErrorCodeEnum.GROUPNAME_USED.getCode(),
								ErrorCodeEnum.GROUPNAME_USED.getDefaultMsg()));
			}
		} else {
			error.put("id",
					new ErrorCode(ErrorCodeEnum.DATA_NOT_FOUND.getCode(),
							ErrorCodeEnum.DATA_NOT_FOUND.getDefaultMsg()));
		}
	}

	@Override
	public void validateDelete(Employee param) {
		// TODO Auto-generated method stub
		
	}

}
