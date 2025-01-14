import java.util.List;

class Person_3 {
    private int id;
    private String name;
    private List<Address> addresses; // Collection for master-detail relationship

    // Getters, setters...
}

public class Address {
    private int id;
    private int personId;
    private String street;

    // Getters, setters...

    public static void main(String[] args) {
    }
}