// Servlet.java
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/generateHtml")
public class GenerateHtmlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        String lastParsedDateStr = (String) sc.getAttribute("lastParsedDate");
        Date lastParsedDate = null;
        
        if (lastParsedDateStr != null) {
            try {
                lastParsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastParsedDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        // Check if x days have passed
        boolean shouldParseXml = false; // logic to determine if it's time to parse based on 'x' days
        
        if (shouldParseXml) {
            String htmlContent = parseAndGenerateHtml();
            
            // Write to cache or file, ensure thread safety
            synchronized (this) { 
                sc.setAttribute("cachedHtml", htmlContent);
                sc.setAttribute("lastParsedDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            }
        }
        
        response.setContentType("text/html");
        response.getWriter().write((String) sc.getAttribute("cachedHtml"));
    }

    private String parseAndGenerateHtml() {
        // XML parsing and HTML generation logic
        return "<html><body>Generated Content</body></html>";
    }
}