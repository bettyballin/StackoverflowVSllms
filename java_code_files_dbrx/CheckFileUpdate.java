import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;

public class CheckFileUpdate {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            // Set up Head request parameters
            HttpHead httphead = new HttpHead("http://www.somehost.com/static_file");
            httphead.setHeader(HttpHeaders.ACCEPT, "application/json");

            System.out.println("Executing: "+httphead);
            CloseableHttpResponse response = httpClient.execute(httphead);
            try {
                // Check for status code and print the headers if success (200)
                int statusCode = response.getStatusLine().getStatusCode();
                System.out.println("Returning HTTP "+statusCode+" message");
                HttpEntity entity = response.getEntity();
                if(entity!=null){
                    HeaderIterator headers = response.headerIterator();
                    while (headers.hasNext()) {
                        Header nextHeader = headers.nextHeader();
                        System.out.println("Header: " + nextHeader);
                    }
                }else{
                    throw new ClientProtocolException("Unexpected response status");
                }
            } finally {response.close();}
         }finally {httpClient.close();}
     }}