import java.lang.String;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.apache.tomcat.util.http.MimeHeaders;

public class HttpServletResponseHelper_2_2 {
    public static void main(String[] args) {
        HttpServletResponse response = new HttpServletResponseWrapper(null) {};
        response.setHeader("Content-Type", "text/plain");
        response.setMimeHeaders(new MimeHeaders());
        response.getMimeHeaders().setHeader("Content-Type", "text/plain");
    }
}