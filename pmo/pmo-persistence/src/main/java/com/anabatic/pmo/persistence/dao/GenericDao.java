package com.anabatic.pmo.persistence.dao;



import java.io.Serializable;
import java.util.List;

import com.anabatic.pmo.persistence.entity.BaseGenericObject;




/**
 * Generic DAO (Data Access Object) with common methods to CRUD POJOs.
 * <p/>
 * <p>Extend this interface if you want typesafe (no casting necessary) DAO's for your
 * domain objects.
 *
 * @param <T>  a type variable
 * @param <PK> the primary key for that type
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 */
public interface GenericDao<T extends BaseGenericObject, PK extends Serializable> {

    /**
     * Generic method used to get all objects of a particular type. This
     * is the same as lookup up all rows in a table.
     *
     * @return List of populated objects
     */
    List<T> getAll();

    /**
     * Gets all records without duplicates.
     * <p>Note that if you use this method, it is imperative that your model
     * classes correctly implement the hashcode/equals methods</p>
     *
     * @return List of populated objects
     */
    List<T> getAllDistinct();
    
    /**
     * Generic method used to get all objects which has status 'LIVE'.
     *
     * @return List of populated objects
     */
    List<T> getAllLive();

    /**
     * Generic method to get an object based on class and identifier. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if
     * nothing is found.
     *
     * @param id the identifier (primary key) of the object to get
     * @return a populated object
     * @see org.springframework.orm.ObjectRetrievalFailureException
     */
    T get(PK id);

    /**
     * Checks for existence of an object of type T using the id arg.
     *
     * @param id the id of the entity
     * @return - true if it exists, false if it doesn't
     */
    boolean exists(PK id);

    /**
     * Generic method to save an object - handles both update and insert.
     *
     * @param object the object to save
     * @return the persisted object
     */
    T save(T object);

    /**
     * Generic method to delete an object based on class and id
     *
     * @param id the identifier (primary key) of the object to remove
     */
    void remove(PK id);
    
//    T authorize(T object, boolean isApproved);
    
    T authorize(T oldObject, T newObject, boolean isApproved);

    List<T> getPagingResults(Long firstResult, Long maxResults);

    Long getRecordCount();
    
    List<T> getUnauthList();

    T getLiveById(PK id);

    boolean isEmpty(String object);
    
    T saveWithoutAuthorize(T object);
    
    void removeWithoutAuthorize(PK id);
    
    T saveBulkUpload(T object);
    
}
