package com.anabatic.pmo.persistence.dao.impl;

import org.springframework.stereotype.Service;

import com.anabatic.pmo.persistence.dao.EmployeeGroupMapper;
import com.anabatic.pmo.persistence.entity.EmployeeGroup;


@Service("employeeGroupMapper")
public class EmployeeGroupMapperImpl extends GenericManagerImpl<Long, EmployeeGroupMapper, EmployeeGroup> implements EmployeeGroupMapper {

	public EmployeeGroupMapperImpl(){
		super(EmployeeGroupMapper.class);
	}

	@Override
	public EmployeeGroup getByName(Object param) {
		this.openDB();
		EmployeeGroup result  = null;
		try {
			result = dao.getByName(param);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.closeDB();
		}
		return result;
	}
	
	@Override
	public EmployeeGroup getById(Object param){
		this.openDB();
		EmployeeGroup result  = null;
		try {
			result = dao.getById(param);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.closeDB();
		}
		return result;
		
	}


}
