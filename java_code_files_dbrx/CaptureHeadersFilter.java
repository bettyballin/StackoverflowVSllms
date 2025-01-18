import java.lang.String;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CaptureHeadersFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        CustomHttpServletResponseWrapper wrapper = new CustomHttpServletResponseWrapper(httpResponse);
        chain.doFilter(request, wrapper); // this will call your servlet / or filter
        System.out.println("Headers: " + wrapper.getHeaderNames()); // or modify as needed before sending response to client
    }

    public static class CustomHttpServletResponseWrapper extends HttpServletResponseWrapper {
       private ByteArrayOutputStream output;

       private PrintWriter writer;

       private ServletOutputStream outputStream;

       public CustomHttpServletResponseWrapper(HttpServletResponse response) throws IOException {
           super(response);
           this.output = new ByteArrayOutputStream();
           this.writer = new PrintWriter(new OutputStreamWriter(this.output, getCharacterEncoding()));
       }

        @Override
        public void sendError(int sc, String msg) throws IOException {
            captureHeadersAndBody(); // You can handle the headers and body here or outside of this method depending on your needs.
            super.sendError(sc, msg);
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return this.outputStream;
        }

       @Override
       public PrintWriter getWriter() throws IOException {
           return this.writer;
       }

        private void captureHeadersAndBody(){
          // Read and modify the headers as needed here or in a different filter / method before sending them to the client.
          System.out.println("Headers: " + super.getHeaderNames());
        }
    }

	public static void main(String[] args) {
	}
}