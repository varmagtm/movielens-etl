package hw.ac.uk.movielens.etl.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * <pre>
 * <b>Description : </b>
 * Composite key movie_genres table.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
@Embeddable
public class MovieGenreCompositeKey implements Serializable {

    private static final long serialVersionUID = -3196991457891231510L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre", nullable = false)
    private Genre genre;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

}
