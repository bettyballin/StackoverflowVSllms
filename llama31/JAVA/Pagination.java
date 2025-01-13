import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Pagination {
    private Connection conn;
    private int pageSize;
    private java.util.List<PageResult> previousPageResults;

    public String getLastIdOnPreviousPage() {
        // retrieve the last id from the previous page
        return previousPageResults.get(previousPageResults.size() - 1).getId();
    }

    public String getNextPageQuery() {
        String lastId = getLastIdOnPreviousPage();
        return "SELECT * FROM data WHERE id > ? ORDER BY id LIMIT ?";
    }

    public void executeNextPageQuery() throws Exception {
        String lastId = getLastIdOnPreviousPage();
        // execute the query with the last id as a parameter
        PreparedStatement pstmt = conn.prepareStatement(getNextPageQuery());
        pstmt.setString(1, lastId);
        pstmt.setInt(2, pageSize);
        ResultSet nextResults = pstmt.executeQuery();
        // Process nextResults
    }

    // Assuming PageResult is a class with an getId() method
    public static class PageResult {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}