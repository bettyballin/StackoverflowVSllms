import org.hibernate.EmptyInterceptor;
import java.lang.String;

public class SchemaInterceptor extends EmptyInterceptor {
    private String schemaName;

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    @Override
    public String onPrepareStatement(String sql) {
        if (schemaName != null) {
            sql = sql.replaceFirst("FROM ", "FROM " + schemaName + ".");
        }
        return sql;
    }

	public static void main(String[] args) {
	}
}