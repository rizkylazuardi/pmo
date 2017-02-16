package com.anabatic.pmo.persistence.dao;

import com.anabatic.pmo.persistence.entity.EmployeeGroup;

public interface EmployeeGroupMapper extends GenericMapper<EmployeeGroup, Long> {
	public EmployeeGroup getByName(Object param);
	public EmployeeGroup getById(Object param);
}
