import java.lang.String;
import oracle.jdbc.pool.OracleDataSource;
import java.sql.SQLException;

public class OracleDatabaseSettings {
    OracleDataSource ods;

    {
        try {
            ods = new OracleDataSource();
            ods.setConnectionProperties("oracle.jdbc.defaultNChar=true;oracle.jdbc.convertNcharLiterals=true;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}