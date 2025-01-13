import java.lang.String;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Person_8_8 {
    private String firstName;
    private String lastName;

    public Person_8(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static void main(String[] args) throws Exception {
        Person_8 person = new Person_8("Jon", "Smith");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(person));
    }
}