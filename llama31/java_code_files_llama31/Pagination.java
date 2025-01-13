/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Pagination {
    private Connection conn;
    private int pageSize;
    private List<PageResult> previousPageResults;

    public String getLastIdOnPreviousPage() {
        return this.previousPageResults.get(this.previousPageResults.size() - 1).getId();
    }

    public String getNextPageQuery() {
        String string = this.getLastIdOnPreviousPage();
        return "SELECT * FROM data WHERE id > ? ORDER BY id LIMIT ?";
    }

    public void executeNextPageQuery() throws Exception {
        String string = this.getLastIdOnPreviousPage();
        PreparedStatement preparedStatement = this.conn.prepareStatement(this.getNextPageQuery());
        preparedStatement.setString(1, string);
        preparedStatement.setInt(2, this.pageSize);
        ResultSet resultSet = preparedStatement.executeQuery();
    }

    public static class PageResult {
        private String id;

        public String getId() {
            return this.id;
        }

        public void setId(String string) {
            this.id = string;
        }
    }
}
