import java.util.List;

public class UserDto {
    private String name;
    private List<Contacts> contacts;

    public UserDto() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    public String getName() {
        return name;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public static void main(String[] args) {
    }
}

class Contacts {
    // Add properties and methods for the Contacts class
}