package com.anabatic.pmo.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.anabatic.pmo.persistence.config.ConfigurationDatabasePMO;
import com.anabatic.pmo.persistence.dao.GenericMapper;
import com.anabatic.pmo.persistence.util.GenericObjectUtil;
import com.anabatic.pmo.service.api.GenericManager;




public class GenericManagerImpl<PK extends Serializable,M extends GenericMapper<T, PK>	 , T>  implements GenericManager<T> {
	
	/**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());

    /**
     * GenericDao instance, set by constructor of child classes
     */
    protected GenericMapper<T, PK> dao;


    public GenericManagerImpl() {
    }

    public GenericManagerImpl(GenericMapper<T, PK> genericDao) {
        this.dao = genericDao;
    }

	@Override
	public List<T> findAll(T object) {
		return dao.findAll(object);
	}

	@Override
	public void insert(T record) {
		dao.insert(record);
	}

	@Override
	public T get(T object) {
		return dao.get(object);
	}

	@Override
	public void delete(T object) {
		dao.delete(object);
	}

	@Override
	public void softDelete(T object) {
		dao.softDelete(object);
		
	}
}
