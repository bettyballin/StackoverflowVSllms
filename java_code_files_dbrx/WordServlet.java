import java.lang.String;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class WordServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get the context of your JSP application. This is not related to this example.
        ServletContext ctx = getServletConfig().getServletContext();
        String content = request.getParameter("docContent");
        System.out.println(content);//For test purpose
       /*Add necessary server-side checks and validation here*/
        //Now you can use the value to generate or modify your word document using a library like Apache POI.
    }

	public static void main(String[] args) {
	}
}