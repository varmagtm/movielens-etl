package hw.ac.uk.movielens.etl.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * <pre>
 * <b>Description : </b>
 * The Movies document in the MongoDB.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
@Document(collection = "movies")
public class MovieDocument {

    @Id
    private long id;

    private String title;

    @Field("release_date")
    private String releaseDate;

    private String video;

    @Field("IMDBURL")
    private String imdbUrl;

    private String[] genres;

    private List<RatingDocument> ratings;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImdbUrl() {
        return imdbUrl;
    }

    public void setImdbUrl(String imdbUrl) {
        this.imdbUrl = imdbUrl;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public List<RatingDocument> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingDocument> ratings) {
        this.ratings = ratings;
    }

}
