import java.io.IOException;
import java.io.InputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.nio.client.CloseableHttpPipeliningClient;
import org.apache.http.nio.client.HttpAsyncClient;
import org.apache.http.nio.reactor.IOReactorException;
import org.apache.http.message.BasicHeader;

public class ReverseProxy {
    public static void main(String[] args) throws IOReactorException, IOException {
        HttpAsyncClient client = new CloseableHttpPipeliningClient();
        client.start();

        // Original URL
        String originalUrl = "http://www.somehostname.com/someproduct/bar.do";

        // Rewritten URL
        String rewrittenUrl = "http://localhost:8080/foo/bar.do";

        HttpRequestBase request = new HttpGet(originalUrl);
        HttpResponse response = client.execute(request).get();

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity entity = response.getEntity();
            // Rewrite the URL
            entity = new HttpEntityWrapper(entity) {
                @Override
                public Header getHeader(String name) {
                    if (name.equals("Location")) {
                        return new BasicHeader("Location", rewrittenUrl);
                    }
                    return super.getHeader(name);
                }
            };
            response.setEntity(entity);
        }

        // Return the rewritten response
        System.out.println(response.getStatusLine());
        InputStream content = response.getEntity().getContent();
        int c;
        while ((c = content.read()) != -1) {
            System.out.print((char) c);
        }
    }
}

class HttpEntityWrapper implements HttpEntity {
    private HttpEntity wrappedEntity;

    public HttpEntityWrapper(HttpEntity wrappedEntity) {
        this.wrappedEntity = wrappedEntity;
    }

    @Override
    public boolean isRepeatable() {
        return wrappedEntity.isRepeatable();
    }

    @Override
    public boolean isChunked() {
        return wrappedEntity.isChunked();
    }

    @Override
    public long getContentLength() {
        return wrappedEntity.getContentLength();
    }

    @Override
    public Header getContentType() {
        return wrappedEntity.getContentType();
    }

    @Override
    public Header getContentEncoding() {
        return wrappedEntity.getContentEncoding();
    }

    @Override
    public InputStream getContent() throws IOException {
        return wrappedEntity.getContent();
    }

    @Override
    public void writeTo(OutputStream outstream) throws IOException {
        wrappedEntity.writeTo(outstream);
    }

    @Override
    public boolean isStreaming() {
        return wrappedEntity.isStreaming();
    }

    @Override
    public void consumeContent() throws IOException {
        wrappedEntity.consumeContent();
    }

    @Override
    public Header getHeader(String name) {
        return wrappedEntity.getHeader(name);
    }

    @Override
    public Header[] getAllHeaders() {
        return wrappedEntity.getAllHeaders();
    }

    @Override
    public void addHeader(Header header) {
        wrappedEntity.addHeader(header);
    }

    @Override
    public void addHeader(String name, String value) {
        wrappedEntity.addHeader(name, value);
    }

    @Override
    public void setHeader(Header header) {
        wrappedEntity.setHeader(header);
    }

    @Override
    public void setHeader(String name, String value) {
        wrappedEntity.setHeader(name, value);
    }

    @Override
    public void setHeaders(Header[] headers) {
        wrappedEntity.setHeaders(headers);
    }

    @Override
    public void removeHeader(Header header) {
        wrappedEntity.removeHeader(header);
    }

    @Override
    public void removeHeaders(String name) {
        wrappedEntity.removeHeaders(name);
    }
}