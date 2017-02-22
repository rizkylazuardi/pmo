package com.anabatic.pmo.service.api;

import java.util.List;

import com.anabatic.pmo.persistence.entity.Employee;

/**
 * 
 * @author rizky.lazuardi
 * Generic Manager 
 * updated by ikhsan 2016-11-01
 */
public interface GenericManager<T> {
	List<T> findAll(T object);
	void insert(T record);
	T get(T object);
	void delete(T object);
	void softDelete(T object);
}
