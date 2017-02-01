/**
 * 
 */
package com.anabatic.pmo.persistence.dao;

import java.io.Serializable;
import java.util.List;


/**
 * @author muchamad.girinata
 *
 */
public interface GenericMapper<T, PK extends Serializable>{
	List<T> findAll(T param);
    void insert(T record);
    T get(T object);
    void delete(T object);
}
