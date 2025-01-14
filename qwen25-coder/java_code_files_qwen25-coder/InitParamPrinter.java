import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class InitParamPrinter extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        out.print("<br>" + this.getServletContext().getInitParameter("GlobalName"));
    }
    public static void main(String[] args) {
    }
}