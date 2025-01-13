import java.lang.String;

public class RuleDefinitionsDAO {
    String sql = "INSERT INTO rule_definitions(RULE_DEFINITION_SYS,rule_definition_type,rule_name,rule_text,rule_comment,rule_message,rule_condition,rule_active,rule_type,current_value,last_modified_by,last_modified_dttm,rule_category_sys,recheck_unit,recheck_period,trackable) VALUES (RULE_DEFINITIONS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static void main(String[] args) {
        RuleDefinitionsDAO dao = new RuleDefinitionsDAO();
        System.out.println(dao.sql);
    }
}