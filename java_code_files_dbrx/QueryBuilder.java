public class QueryBuilder {
    public static void main(String[] args) {
        // List of table names the user has selected
        String[] tables = {"table1", "table2", "table3"}; // tables[0] = "table1", tables[1] = "table2", etc.

        int l = tables.length;

        String queryStart = "\nSELECT * FROM ";
        for (int i = 0; i < l - 1; i++) {
            if (i == 0)
                queryStart += "`" + tables[i] + "` as t" + i;
            else
                queryStart += ", `" + tables[i] + "` as t" + i;
        }
        queryStart += "\nJOIN (`"; // the last table doesn't need a comma or alias
        for (int i = 1; i < l - 1; i++) {
            queryStart += "_to_t" + (i - 1) + "`.linkedID ON `t" + i + "`.linkedId = "; // Joins the tables together based on common keys. Adapt to your structure, this is just an example!
        }
        queryStart += "` t" + l + "_to_t" + (l - 1) + "`.linkedID ON `t0`.linkedKey=`%s.linkedId"; // closing the string

        System.out.println(queryStart);
    }
}