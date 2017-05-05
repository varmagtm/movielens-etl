package hw.ac.uk.movielens.etl.document;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * <pre>
 * <b>Description : </b>
 * The users document in the MongoDB.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
@Document(collection = "users")
public class UserDocument {

    @Id
    private long id;

    private int age;

    private String gender;

    private String occupation;

    @Field("zip_code")
    private String zipCode;

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

}
