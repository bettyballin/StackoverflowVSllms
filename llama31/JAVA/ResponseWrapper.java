import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseWrapper extends HttpServletResponseWrapper {
    private ServletOutputStream outputStream;
    private PrintWriter writer;

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (outputStream == null) {
            outputStream = new ServletOutputStream() {
                // Buffer the output
                private ByteArrayOutputStream buffer = new ByteArrayOutputStream();

                @Override
                public void write(int b) throws IOException {
                    buffer.write(b);
                }

                @Override
                public void flush() throws IOException {
                    // You may want to add code here to handle flushing the buffer
                }

                @Override
                public void close() throws IOException {
                    // You may want to add code here to handle closing the stream
                }
            };
        }
        return outputStream;
    }

    public static void main(String[] args) {
    }
}