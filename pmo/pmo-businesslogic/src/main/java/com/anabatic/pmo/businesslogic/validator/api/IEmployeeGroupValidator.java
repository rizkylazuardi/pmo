package com.anabatic.pmo.businesslogic.validator.api;

import com.anabatic.pmo.businesslogic.validator.IValidator;
import com.anabatic.pmo.persistence.entity.EmployeeGroup;

public interface IEmployeeGroupValidator extends IValidator<EmployeeGroup> {
	public void validateEdit(EmployeeGroup param);
}
