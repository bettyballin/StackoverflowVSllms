import java.util.List;
import java.util.ArrayList;

// Example Java representation of a Person class with associated details
class Person {
    private String id;
    private String name;
    private List<String> nicknames;
    private List<Address> addresses;
    private List<PhoneNumber> phoneNumbers;

    // Constructors, getters, and setters...
}

class Address {
    private String type; // home, work, etc.
    private String street;
    private String city;
    private String state;
    private String zipCode;

    // Constructors, getters, and setters...
}

class PhoneNumber {
    private String type; // home, mobile, work, etc.
    private String number;

    // Constructors, getters, and setters...
}

// Service class to handle requests
public class PeopleService {
    public List<Person> getPeople() {
        // Assume dbCall() fetches data with all necessary joins in a single query
        return dbCall();
    }

    private List<Person> dbCall() {
        // Dummy method for database interaction
        return new ArrayList<>();
    }

    public static void main(String[] args) {
    }
}