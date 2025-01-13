import java.lang.String;

public class QueryGenerator {
    public static void main(String[] args) {
        String[] conditions = {"AND", "OR", "OR"};
        int[][] criteriaIds = {{1, 3, 4}, {5, 6, 7}, {8, 9}};

        StringBuilder query = new StringBuilder();
        query.append("WITH conditions AS (\n");
        for (int i = 0; i < conditions.length; i++) {
            query.append("  SELECT '").append(conditions[i]).append("' as operator, array[");
            for (int j = 0; j < criteriaIds[i].length; j++) {
                query.append(criteriaIds[i][j]);
                if (j < criteriaIds[i].length - 1) {
                    query.append(", ");
                }
            }
            query.append("] as criteria_ids\n");
            if (i < conditions.length - 1) {
                query.append("  UNION ALL\n");
            }
        }
        query.append(")\n");
        query.append("SELECT p.PersonID\n");
        query.append("FROM Person p\n");
        query.append("  JOIN (\n");
        query.append("    SELECT pc.PersonID, c.operator, c.criteria_ids\n");
        query.append("    FROM PersonCriteria pc\n");
        query.append("      JOIN conditions c ON pc.CriteriaID = ANY(c.criteria_ids)\n");
        query.append("  ) k ON p.PersonID = k.PersonID\n");
        query.append("GROUP BY p.PersonID\n");
        query.append("HAVING COUNT(DISTINCT k.operator) = ").append(conditions.length).append("\n");
        query.append("  AND COUNT(DISTINCT k.criteria_ids) = ").append(conditions.length);

        System.out.println(query.toString());
    }
}