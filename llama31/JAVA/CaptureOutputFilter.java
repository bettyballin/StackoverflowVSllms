import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CaptureOutputFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // Create a response wrapper to capture the output
        ResponseWrapper wrapper = new ResponseWrapper(response);

        // Pass the wrapper to the next filter in the chain
        chain.doFilter(request, wrapper);

        // Get the captured output
        String output = wrapper.getOutput();

        // Save the output to a file
        File file = new File("output.html");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(output);
        }
    }
}

class ResponseWrapper extends HttpServletResponseWrapper {
    private StringWriter output = new StringWriter();

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(output);
    }

    public String getOutput() {
        return output.toString();
    }

	public static void main(String[] args) {
	}
}