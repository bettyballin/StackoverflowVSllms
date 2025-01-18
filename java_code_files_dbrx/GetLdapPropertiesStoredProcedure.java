import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class GetLdapPropertiesStoredProcedure {
    private SimpleJdbcCall simpleJdbcCall;

    public GetLdapPropertiesStoredProcedure(DataSource dataSource) {
        this.simpleJdbcCall = new SimpleJdbcCall(dataSource);
        this.simpleJdbcCall.withSchemaName("YOUR_SCHEMA") // Replace YOUR_SCHEMA with the schema name where your function resides
                           .withFunctionName("GET_LDAP_PROPERTIES");
    }

    public Map<String, Object> callProcedure(String inLdapCode) {
        SqlParameterSource in = new MapSqlParameterSource()
            .addValue("in_ldap_code", inLdapCode);

        return simpleJdbcCall.executeFunction(Map.class, in); // Replace Map.class with the actual return type if necessary
    }

    public static void main(String[] args) {
    }
}