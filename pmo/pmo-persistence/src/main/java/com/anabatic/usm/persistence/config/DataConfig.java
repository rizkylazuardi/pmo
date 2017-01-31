package com.anabatic.usm.persistence.config;

import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;


/**
 * @author 3AS 2016
 */
public class DataConfig {
	
	final static Logger log = Logger.getLogger(DataConfig.class);
	
	private static SqlSessionFactory sqlSession = null;	
	
	private String driver = null;
	private String url = null;
	private String username = null;
	private String password = null;
	private SqlSessionFactoryBean sessionFactory=null;
	
	/**
	 * This function use to connect to database
	 * 
	 * @param driver Driver of database
	 * @param url Url location of database
	 * @param username Username that use to connect to database
	 * @param password Password that use to connect to database
	 * @return
	 */
	public DataSource dataSource(String driver, String url, String username, String password) {
		PooledDataSource source = new PooledDataSource();
	    source.setUrl(url);
	    source.setUsername(username);
	    source.setPassword(password);
	    source.setDriver(driver);
	    source.setPoolMaximumActiveConnections(100);
		return source;
	}
	
	/**
	 * This method is using for open SQL Session factory 
	 * 
	 * @return SqlSessionFactory
	 */
	public SqlSessionFactory getInstance(){	
		try{						
			log.info("driver="+driver);
			log.info("url="+url);
			log.info("username="+username);
			log.info("password="+password);
			sessionFactory.setDataSource(dataSource(driver, url, username, password));
			
			sessionFactory.setTypeAliasesPackage("com.anabatic.usm.persistence.entity");
			sessionFactory.setConfigLocation(new ClassPathResource("sqlmap-config.xml")); 
			
			sqlSession = sessionFactory.getObject();
		}catch(Exception e){
			e.printStackTrace();
		}		
		return sqlSession;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SqlSessionFactoryBean getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SqlSessionFactoryBean sessionFactory) {
		this.sessionFactory = sessionFactory;
	}		
}
