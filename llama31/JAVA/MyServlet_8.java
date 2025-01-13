import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet_8_8 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // Call your Java code here
        MyJavaClass myJavaClass = new MyJavaClass();
        String result = myJavaClass.doSomething();
        req.setAttribute("result", result);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }

    public static void main(String[] args) {
    }
}

class MyJavaClass {
    public String doSomething() {
        // Add your Java code here
        return "Something done!";
    }
}