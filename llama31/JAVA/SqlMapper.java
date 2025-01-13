import java.lang.String;
import java.lang.Map;
import java.util.Map;

import org.apache.ibatis.session.SqlMapClient;
import org.apache.ibatis.session.SqlMapClientFactory;

public class SqlMapper {
    SqlMapClient sqlMapClient = SqlMapClientFactory.getSqlMapClient();

    public static void main(String[] args) {
        SqlMapper mapper = new SqlMapper();
        Map<String, Object> resultMap = mapper.sqlMapClient.queryForObject("yourSqlId", null);

        String value1 = (String) resultMap.get("column1");
        String value2 = (String) resultMap.get("column2");
        String value3 = (String) resultMap.get("column3");
    }
}