import java.util.Set;
import java.lang.String;
// Import necessary classes
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class TimeServlet extends GenericServlet {
    public void service(ServletRequest request, ServletResponse response)
        throws ServletException, IOException {
            // Set the content type of the response to "text/html"
            response.setContentType ("text/plain");
            PrintWriter out = response.getWriter();
            try{
                BufferedReader br=new BufferedReader(new InputStreamReader(request.getInputStream()));
                String input;
                while ((input=br.readLine()) != null) {
                    // Parse the request here!
                }
            } catch (Exception e){
                out.println("Error caught: "+e);
            }
        }

    public static void main(String[] args) {
    }
}