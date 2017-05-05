/**
 * 
 */
package hw.ac.uk.movielens.etl.dao;

import hw.ac.uk.movielens.etl.exception.DataAccessException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * <b>Description : </b>
 * Supports the basic DAO CRUD operations.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
public interface GenericDAO {

    /**
     * <pre>
     * <b>Description : </b>
     * Finds the given entity by given ID.
     * 
     * </pre>
     */
    public <T> T findByPrimaryKey(Class<T> entityClass, Serializable id) throws DataAccessException;

    /**
     * <pre>
     * <b>Description : </b>
     * Saves the given entity.
     * 
     * </pre>
     */
    public boolean save(Object entity) throws DataAccessException;

    /**
     * <pre>
     * <b>Description : </b>
     * Merges the given entity with the database.
     * 
     * </pre>
     */
    public <T> boolean merge(T entity) throws DataAccessException;

    /**
     * <pre>
     * <b>Description : </b>
     * Searches for a list of entities matching the given query conditions.
     * 
     * </pre>
     */
    public <T> List<T> search(Class<T> entityClass, Map<String, Object> queryConditions) throws DataAccessException;

    /**
     * <pre>
     * <b>Description : </b>
     * Finds all the entities of the given type.
     * 
     * </pre>
     */
    public <T> List<T> findAll(Class<T> entityClass) throws DataAccessException;

}
