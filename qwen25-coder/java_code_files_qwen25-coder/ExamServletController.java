import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExamServletController extends HttpServlet {
    // Example Servlet code snippet
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int examDurationSeconds = 3600; // 1 hour for example
        request.setAttribute("examDuration", examDurationSeconds);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/questions.jsp");
        dispatcher.forward(request, response);
    }

    public static void main(String[] args) {
    }
}