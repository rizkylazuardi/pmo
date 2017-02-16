package com.anabatic.pmo.service.api;

import com.anabatic.pmo.persistence.entity.EmployeeGroup;

public interface EmployeeGroupService extends GenericManager<EmployeeGroup>{
	public EmployeeGroup getByName(Object param);
	public EmployeeGroup getById(Object param);
}
