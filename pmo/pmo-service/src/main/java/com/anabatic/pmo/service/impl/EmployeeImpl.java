package com.anabatic.pmo.service.impl;

import org.springframework.stereotype.Service;

import com.anabatic.pmo.persistence.dao.EmployeeMapper;
import com.anabatic.pmo.persistence.entity.Employee;
import com.anabatic.pmo.service.api.EmployeeService;

	@Service("EmployeService")
	public class EmployeeImpl extends GenericManagerImpl<Long, EmployeeMapper ,Employee> implements EmployeeService {

		public EmployeeImpl(Class<EmployeeMapper> clazz) {
			super(clazz);
			// TODO Auto-generated constructor stub
		}
}
