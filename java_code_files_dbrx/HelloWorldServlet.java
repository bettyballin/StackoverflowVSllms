import java.io.*;
import javax.servlet.*;

public class HelloWorldServlet extends GenericServlet {
  // This is the main entry point into the Servlet.
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    // Get the PrintWriter for writing the output to the output stream i.e., client browser:
    PrintWriter out = response.getWriter();

    // Write a simple HTML page:
    out.println("<html>\n" + "<head><title>Hello World</title></head>" + "<body bgcolor=\"#FFFFFF\">\n");

    // Output the parameter values from the request:
    String param1 = request.getParameter("paramOne"), param2 = request.getParameter("paramTwo"); // ... and so on

    out.println("<h3>Hello World!</h3><p>\n"
        + "This is a simple example to demonstrate how a Java Servlet works!"
        + "<br/> Parameter1: " + param1 + ", Paramater2:" + param2 + " </p></body>");
  }
}