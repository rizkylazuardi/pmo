package com.anabatic.pmo.service.impl;

import org.springframework.stereotype.Service;

import com.anabatic.pmo.persistence.dao.EmployeeGroupMapper;
import com.anabatic.pmo.persistence.entity.EmployeeGroup;
import com.anabatic.pmo.service.api.EmployeeGroupService;

@Service("employeeGroupService")
public class EmployeeGroupServiceImpl extends GenericManagerImpl<Long, EmployeeGroupMapper, EmployeeGroup> implements EmployeeGroupService {

	public EmployeeGroupServiceImpl(){
		super(EmployeeGroupMapper.class);
	}

	@Override
	public EmployeeGroup getByName(Object param) {
		EmployeeGroup result  = null;
		try {
			result = dao.getByName(param);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}
	
	@Override
	public EmployeeGroup getById(Object param){
		EmployeeGroup result  = null;
		try {
			result = dao.getById(param);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
		
	}


}
