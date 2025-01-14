import java.lang.String;
import org.hibernate.dialect.OracleDialect;
import java.sql.Types;

public class CustomOracleDialect extends OracleDialect {
    public CustomOracleDialect() {
        super();
        registerHibernateType(Types.CLOB, "materialized_clob");
    }

    @Override
    protected String getCreateTableString(boolean isTemporary, boolean deferrable) {
        return isTemporary ? "create global temporary table"
               : "create table in my_tablespace"; // Specify your tablespace here
    }

    public static void main(String[] args) {
    }
}