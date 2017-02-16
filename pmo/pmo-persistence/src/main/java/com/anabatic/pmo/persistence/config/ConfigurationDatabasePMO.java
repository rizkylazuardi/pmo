package com.anabatic.pmo.persistence.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;


/**
 * @author 3AS 2016
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class ConfigurationDatabasePMO {
	
	@Value("${jdbc.driver}")
	public String jdbc_driver;
	@Value("${jdbc.url}")
	public String jdbc_url;
	@Value("${jdbc.username}")
	public String jdbc_username;
	@Value("${jdbc.password}")
	public String jdbc_password;
	
	@Bean(name="pmoConfig")
	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DataConfig dataConfig(){
		DataConfig dataConfig = new DataConfig();
		dataConfig.setSessionFactory(new SqlSessionFactoryBean());
		dataConfig.setDriver(jdbc_driver);
		dataConfig.setUrl(jdbc_url);
		dataConfig.setUsername(jdbc_username);
		dataConfig.setPassword(jdbc_password);
		return dataConfig;
	}
	
	
}
