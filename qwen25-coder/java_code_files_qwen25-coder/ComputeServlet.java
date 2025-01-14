import java.lang.String;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/compute")
public class ComputeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get command line arguments from the form
        String arg1 = request.getParameter("arg1");
        String arg2 = request.getParameter("arg2");

        // Prepare the process builder to call your Java application
        ProcessBuilder pb = new ProcessBuilder(
            "java", "-Xmx128m", "-jar", "myapplication.jar", arg1, arg2);
        try {
            Process p = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String outLine;
            StringBuilder output = new StringBuilder();
            while ((outLine = br.readLine()) != null) {
                output.append(outLine).append("<br>");
            }

            int exitCode = p.waitFor();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (exitCode == 0) {
                out.println(output.toString());
            } else {
                out.println("An error occurred while processing the request.");
            }
            out.println("</body></html>");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            response.getWriter().println(e.getStackTrace());
        } catch (IOException e) {
            response.getWriter().println(e.getStackTrace());
        }
    }

	public static void main(String[] args) {
	}
}