package hw.ac.uk.movielens.etl.document;

/**
 * <pre>
 * <b>Description : </b>
 * The ratings document embedded into the movies document in the MongoDB.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
public class RatingDocument {

    private long user;

    private int rating;

    private long timestamp;

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
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

}
