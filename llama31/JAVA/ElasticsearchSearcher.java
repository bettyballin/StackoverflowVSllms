import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.SearchRequestBuilder;
import org.elasticsearch.search.SearchResponse;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ElasticsearchSearcher {
    public static void main(String[] args) throws UnknownHostException {
        // Create an Elasticsearch client
        Client client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

        // Create a search query
        SearchRequestBuilder searchRequest = client.prepareSearch("database1", "database2", "database3")
                .setQuery(QueryBuilders.matchQuery("content", "search query"));

        // Execute the search query and retrieve results
        SearchResponse response = searchRequest.execute().actionGet();
        SearchHits hits = response.getHits();

        // Process the search hits and display the results
        for (SearchHit hit : hits.getHits()) {
            String databaseName = hit.getIndex();
            String content = hit.getSourceAsString();
            // Display the result with the database name and content
            System.out.println("Database Name: " + databaseName);
            System.out.println("Content: " + content);
        }
    }
}