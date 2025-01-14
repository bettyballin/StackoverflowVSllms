import java.io.Serializable;
import javax.persistence.*;

@Entity
@IdClass(User_41CompositeKey.class)
public class User_41 {
    @Id
    private String firstName;

    @Id
    private String lastName;

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

class User_41CompositeKey implements Serializable {
    private String firstName;
    private String lastName;

    // Default constructor
    public User_41CompositeKey() {
    }

    // Parameterized constructor
    public User_41CompositeKey(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    // Must override equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User_41CompositeKey that = (User_41CompositeKey) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null)
            return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = (firstName != null) ? firstName.hashCode() : 0;
        result = 31 * result + ((lastName != null) ? lastName.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        // Main method
    }
}