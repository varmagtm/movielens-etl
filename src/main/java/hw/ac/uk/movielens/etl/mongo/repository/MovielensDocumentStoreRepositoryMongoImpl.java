package hw.ac.uk.movielens.etl.mongo.repository;

import hw.ac.uk.movielens.etl.document.MovieDocument;
import hw.ac.uk.movielens.etl.document.UserDocument;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * <b>Description : </b>
 * The MongoDB document store repository implementation for movielens databse.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
@Repository
public class MovielensDocumentStoreRepositoryMongoImpl implements MovielensDocumentStoreRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public void saveMovies(List<MovieDocument> movies, boolean drop) {
        if (drop) {
            mongoTemplate.dropCollection(MovieDocument.class);
        }
        mongoTemplate.insertAll(movies);
    }

    public void saveUsers(List<UserDocument> users, boolean drop) {
        if (drop) {
            mongoTemplate.dropCollection(UserDocument.class);
        }
        mongoTemplate.insertAll(users);
    }
}
