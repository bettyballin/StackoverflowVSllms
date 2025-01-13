import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseWrapper_1 extends HttpServletResponseWrapper {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private Map<String, String> headers = new HashMap<>();

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public ServletOutputStream getOutputStream() {
        return new ServletOutputStream() {
            @Override
            public void write(int b) throws IOException {
                outputStream.write(b);
            }
        };
    }

    @Override
    public void addHeader(String name, String value) {
        headers.put(name, value);
        super.addHeader(name, value);
    }

    @Override
    public void setHeader(String name, String value) {
        headers.put(name, value);
        super.setHeader(name, value);
    }

    @Override
    public void setDateHeader(String name, long date) {
        headers.put(name, String.valueOf(date));
        super.setDateHeader(name, date);
    }

    public byte[] getResponseBytes() {
        return outputStream.toByteArray();
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public static void main(String[] args) {
    }
}