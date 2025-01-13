import java.lang.String;

// Example of a vulnerable code snippet from WebGoat
public class SQLInjection {
    public String executeQuery(String username, String password) {
        String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        // ... (you would typically execute the query here and return the result)
        return query; // added a return statement to make the code compile
    }

    public static void main(String[] args) {
        SQLInjection sqlInjection = new SQLInjection();
        String username = "test";
        String password = "test";
        System.out.println(sqlInjection.executeQuery(username, password));
    }
}