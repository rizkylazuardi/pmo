package com.anabatic.pmo.businesslogic.process.api;

import com.anabatic.pmo.persistence.entity.Employee;

public interface LoginProcess {
	public Employee doLogin(Employee param);
	public Boolean doLogout(Employee param);
}
