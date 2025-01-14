import java.lang.String;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;

public class SchemaAwareNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    private String currentSchema = "default_schema";

    public void setCurrentSchema(String schema) {
        this.currentSchema = schema;
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        final StringBuilder builder = new StringBuilder(name.getText().length() + 20);
        builder.append(currentSchema).append(".");
        builder.append(toPluralize(name.getText()));
        return new Identifier(builder.toString(), name.isQuoted());
    }

    private String toPluralize(String name) {
        // Simple pluralization logic
        if (name.endsWith("y")) {
            return name.substring(0, name.length() - 1) + "ies";
        } else if (name.endsWith("s")) {
            return name + "es";
        } else {
            return name + "s";
        }
    }

    public static void main(String[] args) {
    }
}