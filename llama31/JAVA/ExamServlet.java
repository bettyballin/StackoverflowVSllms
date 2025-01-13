import java.lang.String;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ExamServlet.java
public class ExamServlet extends HttpServlet {
    // ...

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Start the exam and record the start time
        long startTime = System.currentTimeMillis();
        request.getSession().setAttribute("startTime", startTime);
        // ...
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        // Calculate the elapsed time on each subsequent request
        long startTime = (long) request.getSession().getAttribute("startTime");
        long elapsedTime = System.currentTimeMillis() - startTime;
        // Display the elapsed time on the page
        request.setAttribute("elapsedTime", elapsedTime);
        // ...
    }

	public static void main(String[] args) {
	}
}