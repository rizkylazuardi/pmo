package com.anabatic.pmo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anabatic.pmo.persistence.dao.EmployeeGroupMapper;
import com.anabatic.pmo.persistence.entity.EmployeeGroup;
import com.anabatic.pmo.service.api.EmployeeGroupService;

@Service("employeeGroupService")
public class EmployeeGroupServiceImpl extends GenericManagerImpl<Long, EmployeeGroupMapper, EmployeeGroup> implements EmployeeGroupService {

	private EmployeeGroupMapper employeeGroupMapper;
	
	@Autowired
	public void setEmployeeGroupMapper(EmployeeGroupMapper employeeGroupMapper) {
		this.employeeGroupMapper = employeeGroupMapper;
		this.dao = employeeGroupMapper;
	}	

	@Override
	public EmployeeGroup getByName(Object param) {
		return employeeGroupMapper.getByName(param);
	}
	
	@Override
	public EmployeeGroup getById(Object param){
		return employeeGroupMapper.getById(param);
	}


}
