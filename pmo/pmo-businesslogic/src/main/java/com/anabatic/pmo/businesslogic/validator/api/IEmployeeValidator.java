package com.anabatic.pmo.businesslogic.validator.api;

import com.anabatic.pmo.businesslogic.validator.IValidator;
import com.anabatic.pmo.persistence.entity.Employee;

public interface IEmployeeValidator extends IValidator<Employee> {
	public void validateEdit(Employee param);
	public void validateDelete(Employee param);
}
