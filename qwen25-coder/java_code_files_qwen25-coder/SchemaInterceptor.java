import org.hibernate.EmptyInterceptor;

public class SchemaInterceptor extends EmptyInterceptor {

    private String currentSchema;

    public void setCurrentSchema(String schema) {
        this.currentSchema = schema;
    }

    @Override
    public String onPrepareStatement(String sql) {
        if (currentSchema != null && !sql.isEmpty()) {
            return "SET search_path TO " + currentSchema + "; " + sql;
        }
        return sql;
    }

    public static void main(String[] args) {
    }
}