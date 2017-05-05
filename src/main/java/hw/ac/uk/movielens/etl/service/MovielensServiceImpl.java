package hw.ac.uk.movielens.etl.service;

import hw.ac.uk.movielens.etl.dao.GenericDAO;
import hw.ac.uk.movielens.etl.document.MovieDocument;
import hw.ac.uk.movielens.etl.document.RatingDocument;
import hw.ac.uk.movielens.etl.document.UserDocument;
import hw.ac.uk.movielens.etl.entities.Movie;
import hw.ac.uk.movielens.etl.entities.MovieGenre;
import hw.ac.uk.movielens.etl.entities.Rating;
import hw.ac.uk.movielens.etl.entities.User;
import hw.ac.uk.movielens.etl.exception.DataAccessException;
import hw.ac.uk.movielens.etl.mongo.repository.MovielensDocumentStoreRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * <b>Description : </b>
 * The service component implementation for the Movielens application.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
@Service
public class MovielensServiceImpl implements MovielensService {

    @Autowired
    private GenericDAO genericDAO;

    @Autowired
    private MovielensDocumentStoreRepository movieDocumentRepository;

    public Collection<Movie> listAllMovies() {
        try {
            return genericDAO.findAll(Movie.class);
        }
        catch (DataAccessException e) {
            return null;
        }
    }

    public Collection<User> listAllUsers() {
        try {
            return genericDAO.findAll(User.class);
        }
        catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public void saveMovieDocuments(Collection<Movie> movies) {
        List<MovieDocument> movieDocuments = null;
        if (movies != null && !movies.isEmpty()) {
            movieDocuments = new ArrayList<MovieDocument>();
            for (Movie movie : movies) {
                if (movie != null) {
                    MovieDocument movieDocument = new MovieDocument();
                    movieDocuments.add(movieDocument);
                    movieDocument.setId(movie.getId());
                    movieDocument.setTitle(movie.getTitle());
                    movieDocument.setReleaseDate(movie.getReleaseDate());
                    movieDocument.setVideo(movie.getVideo());
                    movieDocument.setImdbUrl(movie.getImdbUrl());
                    movieDocument.setId(movie.getId());
                    movieDocument.setId(movie.getId());
                    movieDocument.setId(movie.getId());
                    movieDocument.setId(movie.getId());
                    movieDocument.setId(movie.getId());

                    Collection<MovieGenre> movieGenres = movie.getMovieGenres();
                    if (movieGenres != null && !movieGenres.isEmpty()) {
                        String[] genres = new String[movieGenres.size()];
                        movieDocument.setGenres(genres);
                        int i = 0;
                        for (MovieGenre movieGenre : movieGenres) {
                            if (movieGenre != null) {
                                genres[i++] = movieGenre.getId().getGenre().getGenre();
                            }
                        }
                    }

                    Collection<Rating> movieUserRatings = movie.getRatings();
                    if (movieUserRatings != null && !movieUserRatings.isEmpty()) {
                        List<RatingDocument> ratings = new ArrayList<RatingDocument>();
                        movieDocument.setRatings(ratings);
                        for (Rating movieUserRating : movieUserRatings) {
                            if (movieUserRating != null) {
                                RatingDocument ratingDoc = new RatingDocument();
                                ratingDoc.setUser(movieUserRating.getId().getUser().getId());
                                ratingDoc.setRating(movieUserRating.getRating());
                                ratingDoc.setTimestamp(movieUserRating.getTimestamp());
                                ratings.add(ratingDoc);
                            }
                        }
                    }
                }
            }
            movieDocumentRepository.saveMovies(movieDocuments, true);
        }
    }

    @Override
    public void saveUserDocuments(Collection<User> users) {
        List<UserDocument> userDocuments = null;
        if (users != null && !users.isEmpty()) {
            userDocuments = new ArrayList<UserDocument>();
            for (User user : users) {
                if (user != null) {
                    UserDocument userDocument = new UserDocument();
                    userDocument.setId(user.getId());
                    userDocument.setAge(user.getAge());
                    userDocument.setGender(user.getGender());
                    userDocument.setOccupation(user.getOccupation());
                    userDocument.setZipCode(user.getZipCode());
                    userDocuments.add(userDocument);
                }
            }
            movieDocumentRepository.saveUsers(userDocuments, true);
        }
    }

}
