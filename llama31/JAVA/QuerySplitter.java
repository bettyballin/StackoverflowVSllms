public class QuerySplitter {
    // Split large query into smaller ones
    String sqlQuery1 = "SELECT ... FROM ...";
    String sqlQuery2 = "JOIN ... ON ...";
    String sqlQuery3 = "WHERE ...";

    public static void main(String[] args) {
        // Create an instance of the class to access non-static fields
        QuerySplitter splitter = new QuerySplitter();
        System.out.println(splitter.sqlQuery1);
        System.out.println(splitter.sqlQuery2);
        System.out.println(splitter.sqlQuery3);
    }
}