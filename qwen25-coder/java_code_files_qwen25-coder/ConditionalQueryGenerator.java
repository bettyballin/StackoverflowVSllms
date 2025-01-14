import java.lang.String;
public class ConditionalQueryGenerator {
    String sql = "SELECT * FROM table WHERE 1=1";
    boolean someCondition;
    boolean anotherCondition;
    
    {
        if (someCondition) {
            sql += " AND column1 = 'value'";
        }
        if (anotherCondition) {
            sql += " AND column2 = 'value'";
        }
    }

    public static void main(String[] args) {
    }
}