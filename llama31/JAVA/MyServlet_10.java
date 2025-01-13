import java.lang.String;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet_10 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException {
        ServletContext application = getServletContext();
        // Now you can use the application object
        application.setAttribute("myAttribute", "myValue");
        String myValue = (String) application.getAttribute("myAttribute");
        // ...
    }

	public static void main(String[] args) {
	}
}