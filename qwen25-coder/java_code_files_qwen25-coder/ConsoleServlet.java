import java.lang.String;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ConsoleServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        // Here you would call your Java console application logic to process the input
        String output = "Result of processing: " + command;

        PrintWriter out = response.getWriter();
        out.println(output);
    }

	public static void main(String[] args) {
	}
}