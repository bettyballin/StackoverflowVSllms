import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class RowLevelSecurityInterceptor extends EmptyInterceptor {
    @Override
    public String onPrepareStatement(String sql) {
        // Add filter clause to the query
        sql = sql + " WHERE project_id IN (SELECT project_id FROM user_projects WHERE user_id = :current_user)";
        return sql;
    }

    public static void main(String[] args) {
        // For demonstration purposes, this main method does not actually do anything with the interceptor.
        // In a real application, you would integrate this interceptor with a Hibernate session.
        System.out.println("Interceptor class loaded.");
    }
}