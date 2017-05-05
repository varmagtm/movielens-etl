package hw.ac.uk.movielens.etl.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * <pre>
 * <b>Description : </b>
 * Entity to represents the movies table.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "video")
    private String video;

    @Column(name = "IMDBURL")
    private String imdbUrl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id.movie", fetch = FetchType.LAZY)
    private Collection<MovieGenre> movieGenres;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id.movie", fetch = FetchType.LAZY)
    private Collection<Rating> ratings;

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

    public Collection<MovieGenre> getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(Collection<MovieGenre> movieGenres) {
        this.movieGenres = movieGenres;
    }

    public Collection<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Collection<Rating> movieUserRatings) {
        this.ratings = movieUserRatings;
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + "]";
    }

}
