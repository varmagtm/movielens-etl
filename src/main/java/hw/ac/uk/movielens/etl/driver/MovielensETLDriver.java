package hw.ac.uk.movielens.etl.driver;

import hw.ac.uk.movielens.etl.entities.Movie;
import hw.ac.uk.movielens.etl.entities.MovieGenre;
import hw.ac.uk.movielens.etl.entities.Rating;
import hw.ac.uk.movielens.etl.entities.User;
import hw.ac.uk.movielens.etl.service.MovielensService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <pre>
 * <b>Description : </b>
 * The entry point of the Movielens ETL application. Run this class to start the application.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
public class MovielensETLDriver {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        final ApplicationContext context = new AnnotationConfigApplicationContext("hw.ac.uk.movielens");

        // SqlScriptRunner sqlScriptRunner = context
        // .getBean(MySQLScriptRunner.class);
        // sqlScriptRunner.runScript(context.getEnvironment().getProperty("mysql.script.path"),
        // context.getEnvironment().getProperty("db.url"),
        // context.getEnvironment().getProperty("db.username"),
        // context.getEnvironment().getProperty("db.password"));

        MovielensService movielensService = context.getBean(MovielensService.class);

        Collection<Movie> movies = movielensService.listAllMovies();
        System.out.println(movies);
        writeMovieList(movies);

        Collection<User> users = movielensService.listAllUsers();
        System.out.println(users);
        writeUserList(users);

        movielensService.saveMovieDocuments(movies);
        movielensService.saveUserDocuments(users);
    }

    private static void writeUserList(Collection<User> users) throws IOException {
        if (users != null && !users.isEmpty()) {
            JsonArray usersArray = new JsonArray();
            for (User user : users) {
                if (user != null) {
                    JsonObject userJson = new JsonObject();
                    userJson.addProperty("id", user.getId());
                    userJson.addProperty("age", user.getAge());
                    userJson.addProperty("gender", user.getGender());
                    userJson.addProperty("occupation", user.getOccupation());
                    userJson.addProperty("zip_code", user.getZipCode());
                    usersArray.add(userJson);
                }
            }
            Files.write(Paths.get("./users.json"), gson.toJson(usersArray).getBytes(), StandardOpenOption.CREATE);
        }
    }

    private static void writeMovieList(Collection<Movie> movies) throws IOException {
        if (movies != null && !movies.isEmpty()) {
            JsonArray moviesArray = new JsonArray();
            for (Movie movie : movies) {
                if (movie != null) {
                    JsonObject movieJson = new JsonObject();
                    movieJson.addProperty("id", movie.getId());
                    movieJson.addProperty("title", movie.getTitle());
                    movieJson.addProperty("release_date", movie.getReleaseDate());
                    movieJson.addProperty("video", movie.getVideo());
                    movieJson.addProperty("IMDBURL", movie.getImdbUrl());

                    Collection<MovieGenre> movieGenres = movie.getMovieGenres();
                    if (movieGenres != null && !movieGenres.isEmpty()) {
                        JsonArray genresArray = new JsonArray();
                        for (MovieGenre movieGenre : movieGenres) {
                            if (movieGenre != null) {
                                genresArray.add(movieGenre.getId().getGenre().getGenre());
                            }
                        }
                        movieJson.add("genres", genresArray);
                    }

                    Collection<Rating> movieUserRatings = movie.getRatings();
                    if (movieUserRatings != null && !movieUserRatings.isEmpty()) {
                        JsonArray movieUserRatingsArray = new JsonArray();
                        for (Rating movieUserRating : movieUserRatings) {
                            if (movieUserRating != null) {
                                JsonObject movieUserRatingJson = new JsonObject();
                                movieUserRatingJson.addProperty("user", movieUserRating.getId().getUser().getId());
                                movieUserRatingJson.addProperty("rating", movieUserRating.getRating());
                                movieUserRatingJson.addProperty("timestamp", movieUserRating.getTimestamp());
                                movieUserRatingsArray.add(movieUserRatingJson);
                            }
                        }
                        movieJson.add("ratings", movieUserRatingsArray);
                    }

                    moviesArray.add(movieJson);
                }
            }
            Files.write(Paths.get("./movies.json"), gson.toJson(moviesArray).getBytes(), StandardOpenOption.CREATE);
        }
    }

}
