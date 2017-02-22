package com.anabatic.pmo.service.api;

import com.anabatic.pmo.persistence.entity.Employee;

public interface EmployeeService extends GenericManager<Employee> {
	public Employee getEmployeeByName(Object param);

	public Employee getEmployeeById(Object param);

	public boolean addDataEmploye(Object param);

	public boolean editDataEmployee(Object param);

	public boolean updateSoftDelete(Object param);

	public Employee getEmployeeByUsernameAndGrup(Object param);

	public Employee getEmployeByProject(Object param);

}
