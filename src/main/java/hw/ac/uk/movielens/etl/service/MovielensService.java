package hw.ac.uk.movielens.etl.service;

import hw.ac.uk.movielens.etl.entities.Movie;
import hw.ac.uk.movielens.etl.entities.User;

import java.util.Collection;

/**
 * <pre>
 * <b>Description : </b>
 * The service component for the movielens application.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
public interface MovielensService {

    /**
     * <pre>
	 * <b>Description : </b>
	 * Lists all movies present in the SQL database.
	 * 
	 * @return
	 * </pre>
     */
    public Collection<Movie> listAllMovies();

    /**
     * <pre>
     * <b>Description : </b>
     * Lists all users present in the SQL database.
     * 
     * @return
     * </pre>
     */
    public Collection<User> listAllUsers();

    /**
     * <pre>
     * <b>Description : </b>
     * Saves all movie documents to MongoDB.
     * 
     * @return
     * </pre>
     */
    public void saveMovieDocuments(Collection<Movie> movies);

    /**
     * <pre>
     * <b>Description : </b>
     * Saves all user documents to MongoDB.
     * 
     * @return
     * </pre>
     */
    public void saveUserDocuments(Collection<User> users);

}
