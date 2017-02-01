package com.anabatic.pmo.persistence;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.anabatic.pmo.persistence.config.DataConfig;



public class Test {
	
	
	public static void main(String[] args) {
		DataConfig dataConfig = new DataConfig();
		dataConfig.setSessionFactory(new SqlSessionFactoryBean());
		dataConfig.setDriver("org.postgresql.Driver");
		dataConfig.setUrl("jdbc:postgresql://10.50.51.6:5432/ibanking_ib_new");
		dataConfig.setUsername("postgres");
		dataConfig.setPassword("123456");
		System.out.println(dataConfig.getInstance());
	//	System.out.println(userManager.getCountUser());
	}
}
