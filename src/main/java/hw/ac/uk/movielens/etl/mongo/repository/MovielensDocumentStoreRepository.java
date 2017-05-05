package hw.ac.uk.movielens.etl.mongo.repository;

import hw.ac.uk.movielens.etl.document.MovieDocument;
import hw.ac.uk.movielens.etl.document.UserDocument;

import java.util.List;

/**
 * <pre>
 * <b>Description : </b>
 * The repository for Movielens document store database.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
public interface MovielensDocumentStoreRepository {

    /**
     * <pre>
     * <b>Description : </b>
     * Saves all the movie documents given.
     * 
     * @param movies
     * @param drop, if true drops all the documents present and inserts the given documents.
     * </pre>
     */
    public void saveMovies(List<MovieDocument> movies, boolean drop);

    /**
     * <pre>
     * <b>Description : </b>
     * Saves all the user documents given.
     * 
     * @param users
     * @param drop, if true drops all the documents present and inserts the given documents.
     * </pre>
     */
    public void saveUsers(List<UserDocument> users, boolean drop);

}
