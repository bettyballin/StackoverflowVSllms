import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.HttpClients;

public class HttpGetExample {
   public static void main(String[] args) throws Exception {
       CloseableHttpClient client = null;
      try {
          client = createHttpClientWithProxy(); // Create an instance of httpclient with the proxy configuration

          String url = "http://www.example.com";  // The requested URL
          HttpGet getRequest = new HttpGet(url);   // Constructing the GET request

          CookieStore cookieStore = new BasicCookieStore(); // We can use a cookie store if needed but since we are not logging in, it is empty here
          HttpContext httpContext = new BasicHttpContext();  // Create a context so that other parts of code can see and manipulate the request/response etc.
          httpContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);   // Attach your cookies to the httpcontext
          HttpResponse response = client.execute(getRequest, httpContext);  // Execute the Get method

          if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {    // If not a HTTP400 code...
             System.out.println("HTTP Error " + response.getStatusLine());   // Some logging here, you can decide how to handle/log error codes in your app
          } else {
               BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));  // Get the stream from httpresponse and read it...
              StringBuilder resultBuilder = new StringBuilder();    // Result buffer
             String line;
             while ((line = rd.readLine()) != null) {   // Loop for each returned response line..
                 resultBuilder.append(line);      // Append as a string to the buffered line...
              }
        System.out.println("Result: " + resultBuilder );     // Prints entire HTML if needed, otherwise store it somewhere from where you can process later
       }  // End of HTTP Status response check and content fetch
    } catch(Exception e) {
      System.err.print(e);   // Debug purposes
    } finally {         // Always close a consumed HttpClient
        client.close();      // Close connection, no need to open it again since you are not making another http request within the same thread.
     }  // End of catch block for HTTP Status error codes
   }  // end of main method

   private static CloseableHttpClient createHttpClientWithProxy() {
       // Create an instance of httpclient with the proxy configuration
       // For this example, we'll create a default client
       return HttpClients.createDefault();
   }
} // end of class HttpGetExample