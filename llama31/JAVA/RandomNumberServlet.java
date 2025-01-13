import java.lang.String;
// RandomNumberServlet.java
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RandomNumberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int randomNumber = (int) (Math.random() * 100);
        response.setContentType("text/plain");
        response.getWriter().print(randomNumber);
    }

	public static void main(String[] args) {
	}
}