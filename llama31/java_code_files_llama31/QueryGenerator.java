/*
 * Decompiled with CFR 0.152.
 */
public class QueryGenerator {
    public static void main(String[] stringArray) {
        String[] stringArray2 = new String[]{"AND", "OR", "OR"};
        int[][] nArrayArray = new int[][]{{1, 3, 4}, {5, 6, 7}, {8, 9}};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WITH conditions AS (\n");
        for (int i = 0; i < stringArray2.length; ++i) {
            stringBuilder.append("  SELECT '").append(stringArray2[i]).append("' as operator, array[");
            for (int j = 0; j < nArrayArray[i].length; ++j) {
                stringBuilder.append(nArrayArray[i][j]);
                if (j >= nArrayArray[i].length - 1) continue;
                stringBuilder.append(", ");
            }
            stringBuilder.append("] as criteria_ids\n");
            if (i >= stringArray2.length - 1) continue;
            stringBuilder.append("  UNION ALL\n");
        }
        stringBuilder.append(")\n");
        stringBuilder.append("SELECT p.PersonID\n");
        stringBuilder.append("FROM Person p\n");
        stringBuilder.append("  JOIN (\n");
        stringBuilder.append("    SELECT pc.PersonID, c.operator, c.criteria_ids\n");
        stringBuilder.append("    FROM PersonCriteria pc\n");
        stringBuilder.append("      JOIN conditions c ON pc.CriteriaID = ANY(c.criteria_ids)\n");
        stringBuilder.append("  ) k ON p.PersonID = k.PersonID\n");
        stringBuilder.append("GROUP BY p.PersonID\n");
        stringBuilder.append("HAVING COUNT(DISTINCT k.operator) = ").append(stringArray2.length).append("\n");
        stringBuilder.append("  AND COUNT(DISTINCT k.criteria_ids) = ").append(stringArray2.length);
        System.out.println(stringBuilder.toString());
    }
}
