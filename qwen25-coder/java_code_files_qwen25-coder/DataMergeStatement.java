import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataMergeStatement {
    public static void main(String[] args) {
        String sql = "merge into data " +
                     "using (select ? as id, ? as key, ? as value from dual) src " +
                     "on (data.id = src.id and data.key = src.key) " +
                     "when matched then update set value = src.value " +
                     "when not matched then insert (id, key, value) values (src.id, src.key, src.value)";
        
        Connection connection = null; // TODO: Initialize the connection
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "someid");
            pstmt.setString(2, "testKey");
            pstmt.setString(3, "someValue");
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}