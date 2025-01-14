import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class LuceneIndexBuilder {

    private static final String SOLR_URL = "http://localhost:8983/solr/my_core";

    public static void main(String[] args) throws IOException, SolrServerException, SQLException {
        HttpSolrClient solrClient = new HttpSolrClient.Builder(SOLR_URL).build();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "user", "password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, title, content FROM articles")) {

            while (rs.next()) {
                SolrInputDocument document = new SolrInputDocument();
                document.addField("id", rs.getString("id"));
                document.addField("title", rs.getString("title"));
                document.addField("content", rs.getString("content"));

                solrClient.add(document);
            }

            solrClient.commit();
        } finally {
            solrClient.close();
        }
    }
}