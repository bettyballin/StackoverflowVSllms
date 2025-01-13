import java.sql.Types;
import org.hibernate.dialect.PostgreSQLDialect;
import org.hibernate.type.UUIDCharType;

public class CustomPostgreSQLDialect extends PostgreSQLDialect {
    public CustomPostgreSQLDialect() {
        super();
        registerColumnType(Types.UUID, "uuid");
    }

    public static void main(String[] args) {
    }
}