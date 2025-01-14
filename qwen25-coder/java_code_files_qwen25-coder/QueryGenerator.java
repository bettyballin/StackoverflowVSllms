import java.lang.String;
public class QueryGenerator {
    StringBuilder query = new StringBuilder("SELECT * FROM users WHERE 1=1 ");
    String username;
    String email;

    {
        if (username != null) {
            query.append("AND username = ? ");
        }
        if (email != null) {
            query.append("AND email = ? ");
        }
    }

    public static void main(String[] args) {
    }
}