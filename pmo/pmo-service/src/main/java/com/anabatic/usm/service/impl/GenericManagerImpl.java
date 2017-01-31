package com.anabatic.usm.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.anabatic.usm.persistence.config.ConfigurationDatabase;
import com.anabatic.usm.persistence.dao.GenericMapper;
import com.anabatic.usm.persistence.util.GenericObjectUtil;
import com.anabatic.usm.service.api.GenericManager;




public class GenericManagerImpl<PK extends Serializable,M extends GenericMapper<T, PK>	 , T>  implements GenericManager<T> {
	
	@Autowired
	ConfigurationDatabase confDB;
	
	protected SqlSession sqlSession = null;
	
	protected Class<M> clazz =  null;
	protected M dao  = null;
	
	public GenericManagerImpl(Class<M> clazz){
		this.clazz = clazz;
	}
	
	
	
	public void openDB() {
		sqlSession = confDB.dataConfig().getInstance().openSession();
		this.dao = this.sqlSession.getMapper(clazz);
	}

	public void closeDB() {
		sqlSession.close();
	}

	public void commitDB() {
		sqlSession.commit();
	}

	public void rollbackDB() {
		sqlSession.rollback();	
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(T object) {
		try {
			object = (T) GenericObjectUtil.setGenericObjectValue(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao.findAll(object);
	}

	@SuppressWarnings("unchecked")
	public void insert(T record) {
		try {
			record = (T) GenericObjectUtil.setGenericObjectValue(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.insert(record);
	}

	@SuppressWarnings("unchecked")
	public T get(T object) {
		try {
			object = (T) GenericObjectUtil.setGenericObjectValue(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao.get(object);
	}

	@SuppressWarnings("unchecked")
	public void delete(T object) {
		try {
			object = (T) GenericObjectUtil.setGenericObjectValue(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.delete(object);
	}
}
