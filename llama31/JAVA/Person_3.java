import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Person class (OO)
public class Person_3 {
    private String name;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

// Address class (OO)
class Address {
    private String street;
    private String city;
    private String zip;
    private int id;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

// Data Access Object (DAO) to interact with the database (procedural)
public class Person_3DAO {
    public void savePerson(Person person) throws SQLException {
        // Use JDBC to insert data into the database
        Connection conn = DriverManager.getConnection("...");
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO persons (name, address_id) VALUES (?, ?)");
        stmt.setString(1, person.getName());
        stmt.setInt(2, person.getAddress().getId());
        stmt.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {
        PersonDAO personDAO = new PersonDAO();
        Person person = new Person();
        person.setName("John Doe");
        Address address = new Address();
        address.setId(1);
        person.setAddress(address);
        personDAO.savePerson(person);
    }
}