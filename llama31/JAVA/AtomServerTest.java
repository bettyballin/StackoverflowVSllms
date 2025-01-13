import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtomServerTest {
    @Test
    public void testGetAtomFeed() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8080/atom/feed");
        CloseableHttpResponse response = httpClient.execute(request);

        // Verify response status code
        assertEquals(200, response.getStatusLine().getStatusCode());

        // Verify Atom feed format and content
        String atomFeed = EntityUtils.toString(response.getEntity());
        // Use xmllint or xmlschema to validate the Atom feed against the schema
        // ...
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("AtomServerTest");
    }
}