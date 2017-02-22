package com.anabatic.pmo.service.impl;

import org.springframework.stereotype.Service;

import com.anabatic.pmo.persistence.dao.EmployeeMapper;
import com.anabatic.pmo.persistence.entity.Employee;
import com.anabatic.pmo.service.api.EmployeeService;

@Service("EmployeService")
public class EmployeeImpl extends
		GenericManagerImpl<Long, EmployeeMapper, Employee> implements
		EmployeeService {

	public EmployeeImpl(Class<EmployeeMapper> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
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
	public Employee getEmployeeByUsernameAndGrup(Object param) {
		Employee result = null;
		try {
			result = dao.getEmployeeByProject(param);
		} catch (Exception e) {
			e.printStackTrace();
			
		return null;
		}
		return result;
	}

	@Override
	public Employee getEmployeByProject(Object param) {
		Employee result = null;
		try {
			result = dao.getEmployeeByProject(param);
		} catch (Exception e) {
			e.printStackTrace();
		return null;
	}
		return result;
	}
}