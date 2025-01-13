import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class UserDAO_1_1 {
    public static void main(String[] args) {
        // Create a connection to the database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("url", "user", "password");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return;
        }

        UserDAO_1 userDAO = new UserDAO_1(connection);
        userDAO.insertUser("userId", new MyUser("John", "Doe", "Male"));
    }

    private Connection connection;

    public UserDAO_1(Connection connection) {
        this.connection = connection;
    }

    public void insertUser(String userId, MyUser myUser) {
        java.util.Date myDate = new java.util.Date("01/01/2009");

        String sql = "INSERT INTO USERS (USER_ID, FIRST_NAME, LAST_NAME, SEX, DATE) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, myUser.getFirstName());
            pstmt.setString(3, myUser.getLastName());
            pstmt.setString(4, myUser.getSex());
            pstmt.setDate(5, new java.sql.Date(myDate.getTime()));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting user: " + e.getMessage());
        }
    }

    public static class MyUser {
        private String firstName;
        private String lastName;
        private String sex;

        public MyUser(String firstName, String lastName, String sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getSex() {
            return sex;
        }
    }
}