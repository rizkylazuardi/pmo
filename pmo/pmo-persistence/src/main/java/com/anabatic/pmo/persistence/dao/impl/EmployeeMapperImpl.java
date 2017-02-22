package com.anabatic.pmo.persistence.dao.impl;

import org.springframework.stereotype.Service;

import com.anabatic.pmo.persistence.dao.EmployeeMapper;
import com.anabatic.pmo.persistence.entity.Employee;

@Service("employeMapper")
public class EmployeeMapperImpl extends
		GenericManagerImpl<Long, EmployeeMapper, Employee> implements
		EmployeeMapper {
	
	public EmployeeMapperImpl(){
		super(EmployeeMapper.class);
	}
	

	@Override
	public Employee getEmployeeByName(Object param) {
		Employee result = null;
		try {
			result = dao.getEmployeeByName(param);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	@Override
	public Employee getEmployeeById(Object param) {
		Employee result = null;
		try {
			result = dao.getEmployeeById(param);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	
	@Override
	public boolean editDataEmployee(Object param) {
		boolean result = true;
		try {
			result = dao.editDataEmployee(param);
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
		return result;
	}

	@Override
	public boolean updateSoftDelete(Object param) {
		boolean result = true;
		try {
			result = dao.updateSoftDelete(param);
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
		return result;
	}

	@Override
	public boolean addDataEmploye(Object param) {
		boolean result = true;
		try {
			result = dao.addDataEmploye(param);
		} catch (Exception e) {
			e.printStackTrace();

			return false;

		}
		return result;

	}

	@Override
	public Employee getAllEmployee(Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByUserNameAndGrup(Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByProject(Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	
}