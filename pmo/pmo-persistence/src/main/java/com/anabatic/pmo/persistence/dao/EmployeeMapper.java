package com.anabatic.pmo.persistence.dao;

import com.anabatic.pmo.persistence.entity.Employee;

public interface EmployeeMapper extends GenericMapper<Employee, Long> {
public Employee getAllEmployee (Object param);	
public Employee getEmployeeByName (Object param);
public Employee getEmployeeByUserNameAndGrup (Object param);
public Employee getEmployeeById(Object param);
public Employee getEmployeeByProject(Object param);
public boolean addDataEmploye(Object param);
public boolean editDataEmployee(Object param);
public boolean updateSoftDelete(Object param);

}
