import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(User_42CompositeKey.class)
public class User_42 {
    @Id
    private String firstName;
    
    @Id
    private String lastName;

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
	
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

class User_42CompositeKey implements Serializable {
    private String firstName;
    private String lastName;

    // must override equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User_42CompositeKey that = (User_42CompositeKey) o;

        if (!firstName.equals(that.firstName)) return false;
        return lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }
}