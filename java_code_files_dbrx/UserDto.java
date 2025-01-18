import java.util.List;
// Assume you have the following DTO class:
public class UserDto {
    private String name;
    private List<Contact> contacts;

    public UserDto(String name, List<Contact> contacts) {
        this.name = name;
        this.contacts = contacts;
    }
    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public static void main(String[] args) {
    }
}

// Assuming Contact class
class Contact {
    // contact fields and methods
}