import java.lang.String;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorForwarder {

    HttpServletRequest request;
    HttpServletResponse response;

    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
        dispatcher.forward(request, response);
    }

    public static void main(String[] args) {
    }
}