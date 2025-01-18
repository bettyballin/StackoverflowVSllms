import java.lang.String;
import oracle.jdbc.pool.OracleDataSource;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Types;

public class OracleDAO {
    public static void main(String[] args) throws Exception {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:app_user/pass@server:1521:sid");
        Connection conn = ods.getConnection();
        CallableStatement st = conn.prepareCall("INSERT INTO tableA (some_id) VALUES (?) RETURNING ROWID INTO ?");
        st.setInt(1, 1);
        st.registerOutParameter(2, Types.VARCHAR);
        st.executeUpdate(); // Use executeUpdate for DML statements instead of execute()
        String rowId = st.getString(2);
    }
}