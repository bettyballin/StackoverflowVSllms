import java.lang.String;
import foo.Employee;
import javax.servlet.http.HttpServletRequest;

public class EmployeeServlet {
    HttpServletRequest request;

    {
        request.setAttribute("ja", new foo.Employee());
    }

    public static void main(String[] args) {
    }
}