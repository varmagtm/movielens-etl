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
 * Entity to represents the users table.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int age;

    private String gender;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id.user", fetch = FetchType.LAZY)
    private Collection<Rating> ratings;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Collection<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Collection<Rating> movieUserRatings) {
        this.ratings = movieUserRatings;
    }

    @Override
    public String toString() {
        return "User [id=" + id + "]";
    }

}
