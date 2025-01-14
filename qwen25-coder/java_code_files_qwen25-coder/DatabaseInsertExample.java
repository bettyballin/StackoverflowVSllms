import java.lang.String;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseInsertExample {

    public static void main(String[] args) {
        String userId = "user";
        MyUser myUser = new MyUser("FirstTest", "LastTest", "M");
        Date myDate = new Date(); // Example date, replace with your logic to get the date

        try (Connection conn = DriverManager.getConnection("jdbc:yourDatabaseUrl", "username", "password")) {
            String sql = "INSERT INTO USERS (USER_ID, FIRST_NAME, LAST_NAME, SEX, CRDATE) VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, myUser.GetFirstname());
            preparedStatement.setString(3, myUser.GetLastname());
            preparedStatement.setString(4, myUser.GetSex());
            // Convert java.util.Date to java.sql.Date
            preparedStatement.setDate(5, new java.sql.Date(myDate.getTime()));

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static class MyUser {
        private String firstname;
        private String lastname;
        private String sex;

        public MyUser(String firstname, String lastname, String sex) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.sex = sex;
        }

        public String GetFirstname() {
            return firstname;
        }

        public String GetLastname() {
            return lastname;
        }

        public String GetSex() {
            return sex;
        }
    }
}