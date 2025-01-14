import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class RuleDefinitionInserter {

    public static void main(String[] args) {
        String sql = "INSERT INTO rule_definitions(RULE_DEFINITION_SYS,rule_definition_type," +
                "rule_name,rule_text,rule_comment,rule_message,rule_condition,rule_active," +
                "rule_type,current_value,last_modified_by,last_modified_dttm," +
                "rule_category_sys,recheck_unit,recheck_period,trackable)" +
                "VALUES(RULE_DEFINITIONS_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        // You need to initialize your database connection here
        Connection connection = null;

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // Ensure you set the correct number of parameters
            pstmt.setString(1, "your_rule_definition_type");
            pstmt.setString(2, "your_rule_name");
            pstmt.setString(3, "your_rule_text");
            pstmt.setString(4, "your_rule_comment");
            pstmt.setString(5, "your_rule_message");
            pstmt.setString(6, "your_rule_condition");
            pstmt.setBoolean(7, true); // or false depending on your rule_active value
            pstmt.setInt(8, 1); // or any appropriate integer for rule_type
            pstmt.setString(9, "your_current_value");
            pstmt.setString(10, "your_last_modified_by");
            pstmt.setTimestamp(11, new Timestamp(new Date().getTime())); // current timestamp
            pstmt.setInt(12, 1); // or any appropriate integer for rule_category_sys
            pstmt.setString(13, "your_recheck_unit");
            pstmt.setInt(14, 10); // or any appropriate integer for recheck_period
            pstmt.setBoolean(15, true); // or false depending on your trackable value

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}