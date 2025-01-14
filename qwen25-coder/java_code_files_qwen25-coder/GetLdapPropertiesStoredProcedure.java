import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class GetLdapPropertiesStoredProcedure extends StoredProcedure {

    protected GetLdapPropertiesStoredProcedure(DataSource dataSource) {
        super(dataSource, "get_ldap_properties");
        setFunction(true);
        declareParameter(new SqlReturnResultSet("rs", new ProductPropertiesMapper()));
        declareParameter(new SqlParameter("in_ldap_code", Types.VARCHAR));
        compile();
    }

    public Properties execute(String productCode) {
        Map<String, Object> input = new HashMap<>();
        input.put("in_ldap_code", productCode);

        Map<String, Object> results = super.execute(input);

        Collection<Map<String, Object>> entries = (Collection<Map<String, Object>>) results.get("rs");
        Properties properties = new Properties();
        for (Map<String, Object> entry : entries) {
            properties.putAll(entry);
        }
        return properties;
    }

    public static void main(String[] args) {
        // You can add code here to test the StoredProcedure
    }
}

class ProductPropertiesMapper implements RowMapper<Map<String, Object>> {
    @Override
    public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
        Map<String, Object> map = new HashMap<>();
        // Implement the mapping logic here
        return map;
    }
}