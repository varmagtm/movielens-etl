package hw.ac.uk.movielens.etl.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * <pre>
 * <b>Description : </b>
 * Embedded key for ratings table.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
@Embeddable
public class MovieUser implements Serializable {

	private static final long serialVersionUID = -5961735720498322330L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movie", nullable = false)
	private Movie movie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user", nullable = false)
	private User user;

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
