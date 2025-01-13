import javax.servlet.*;
import java.io.*;

@WebServlet("/myServlet")
public class MyServlet_15_15 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("param");
        MyJavaClass myJavaClass = new MyJavaClass();
        String result = myJavaClass.myMethod(param);
        response.setContentType("text/plain");
        response.getWriter().write(result);
    }

    public static void main(String[] args) {
    }
}