package com.anabatic.pmo.persistence.dao;

import com.anabatic.pmo.persistence.entity.Employee;

public interface EmployeeMapper extends GenericMapper<Employee, Long> {
public void getAllEmployee (Object param);	

}
