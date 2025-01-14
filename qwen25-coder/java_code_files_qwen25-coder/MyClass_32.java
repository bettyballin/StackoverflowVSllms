import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.stream.*;

public class MyClass {

    public void deleteInChunks(Connection conn, List<Integer> ids) throws Exception {
        final int batchSize = 500; // Adjust based on your limits and performance tests
        for (int i = 0; i < ids.size(); i += batchSize) {
            int endIdx = Math.min(ids.size(), i + batchSize);
            String query = "DELETE FROM FOO WHERE ID IN (" +
                    String.join(",", ids.subList(i, endIdx).stream().map(String::valueOf).toArray(String[]::new)) + ")";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.executeUpdate();
            }
        }
    }

}