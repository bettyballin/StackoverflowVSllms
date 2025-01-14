import java.lang.String;
public class UserQueryBuilder {
    StringBuilder query = new StringBuilder("SELECT id, name FROM users WHERE 1=1");
    String userLogin = null; // or any value
    String finalQuery;

    {
        if (userLogin != null) {
            query.append(" AND login = '").append(userLogin).append("'");
        }
        finalQuery = query.toString();
    }

    public static void main(String[] args) {
    }
}