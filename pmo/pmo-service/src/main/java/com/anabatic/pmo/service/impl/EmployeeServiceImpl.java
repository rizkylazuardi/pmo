package com.anabatic.pmo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anabatic.pmo.persistence.dao.EmployeeMapper;
import com.anabatic.pmo.persistence.entity.Employee;
import com.anabatic.pmo.service.api.EmployeeService;

@Service("employeService")
public class EmployeeServiceImpl extends
		GenericManagerImpl<Long, EmployeeMapper, Employee> implements
		EmployeeService {

	private EmployeeMapper employeeMapper;
	
	@Autowired
	public void setEmployeeMapper(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
		this.dao = employeeMapper;
	}	

	@Override
	public Employee getEmployeeByName(Object param) {
		return employeeMapper.getEmployeeByName(param);
	}

	@Override
	public Employee getEmployeeById(Object param) {
		return employeeMapper.getEmployeeById(param);
	}

	
	@Override
	public boolean editDataEmployee(Object param) {
		return employeeMapper.editDataEmployee(param);
	}

	@Override
	public boolean updateSoftDelete(Object param) {
		return employeeMapper.updateSoftDelete(param);
	}

	@Override
	public boolean addDataEmploye(Object param) {
		return employeeMapper.addDataEmploye(param);

	}

	@Override
	public Employee getEmployeeByUsernameAndGrup(Object param) {
		return employeeMapper.getEmployeeByUserNameAndGrup(param);
	}

	@Override
	public Employee getEmployeByProject(Object param) {
		return employeeMapper.getEmployeeByProject(param);
	}
}