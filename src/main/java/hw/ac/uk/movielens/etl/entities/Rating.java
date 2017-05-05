package hw.ac.uk.movielens.etl.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * <pre>
 * <b>Description : </b>
 * Entity to represents the users table.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
@Entity
@Table(name = "ratings", uniqueConstraints = { @UniqueConstraint(columnNames = { "user", "movie" }) })
public class Rating {

    @EmbeddedId
    private MovieUser id;

    private int rating;

    private long timestamp;

    public MovieUser getId() {
        return id;
    }

    public void setId(MovieUser id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Rating [movie=" + id.getMovie().getId() + ", genre=" + id.getUser().getId() + ", rating="
            + rating + ", timestamp=" + timestamp + "]";
    }

}
