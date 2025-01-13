// Ensure Apache HttpClient libraries are included in your project's classpath
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.IOException;

public class Main_741 {

    public static void main(String[] args) throws IOException {
        // Create a WebDAV client
        String url = "http://example.com/webdav/document.docx";
        HttpPut put = new HttpPut(url);

        // Set the document content
        put.setEntity(new FileEntity(new File("document.docx")));

        // Execute the request
        org.apache.http.client.HttpClient client = HttpClients.createDefault();
        org.apache.http.HttpResponse response = client.execute(put);
        System.out.println(response.getStatusLine().getStatusCode());
    }
}