import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Customer {
    private int id;
    private String name;
    private String country;

    public Customer(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}

class VirtualList {
    private Connection connection;
    private String query;
    private int pageSize;

    public VirtualList(Connection connection, String query, int pageSize) {
        this.connection = connection;
        this.query = query;
        this.pageSize = pageSize;
    }

    public Customer get(int index) {
        try (Statement statement = connection.createStatement()) {
            int offset = index / pageSize * pageSize;
            String paginatedQuery = query + " LIMIT " + pageSize + " OFFSET " + offset;
            try (ResultSet resultSet = statement.executeQuery(paginatedQuery)) {
                int currentIndex = offset;
                while (resultSet.next()) {
                    if (currentIndex == index) {
                        return new Customer(resultSet.getInt("ID"), resultSet.getString("NAME"), resultSet.getString("COUNTRY"));
                    }
                    currentIndex++;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving customer: " + e.getMessage());
        }
        return null;
    }
}

public class Main_176 {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Replace with your actual database connection URL and credentials
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase", "myuser", "mypassword");
        } catch (SQLException e) {
            System.out.println("Error obtaining database connection: " + e.getMessage());
            return;
        }

        String query = "SELECT * FROM CUSTOMER WHERE COUNTRY='Moldovia'";
        VirtualList virtualList = new VirtualList(connection, query, 50);

        // Access the list
        Customer customer = virtualList.get(10);
        if (customer != null) {
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("Customer Name: " + customer.getName());
            System.out.println("Customer Country: " + customer.getCountry());
        } else {
            System.out.println("Customer not found");
        }
    }
}