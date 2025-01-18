import java.util.Map;
import java.util.ArrayList;

public class SqlStatementGenerator {

    public String generateInsertStatement(String tableName, Map<String, Object> values) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(tableName).append(' ');

        ArrayList<String> columnNames = new ArrayList<>(values.keySet());
        for (int i = 0; i < columnNames.size(); ++i) {
            if (i == 0) {
                sb.append("(").append(columnNames.get(i));
            } else {
                sb.append(", ").append(columnNames.get(i));
            }
        }
        sb.append(')');

        String questionMarks = StringUtils.repeatParameter("?, ", columnNames.size());
        questionMarks = questionMarks.substring(0, questionMarks.length() - 2); // Remove the last ", "
        sb.append(" VALUES (").append(questionMarks).append(')');

        return sb.toString();
    }

    public String generateUpdateStatement(String tableName, Map<String, Object> values, String whereClause) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ").append(tableName).append(" SET ");

        ArrayList<String> columnNames = new ArrayList<>(values.keySet());
        for (int i = 0; i < columnNames.size(); ++i) {
            if (i == 0) {
                sb.append(columnNames.get(i)).append('=').append("?");
            } else {
                sb.append(", ").append(columnNames.get(i)).append('=').append('?');
            }
        }

        sb.append(" WHERE ").append(whereClause);
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}

class StringUtils {
    public static String repeatParameter(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}