import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyChat extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ArrayList<String> myMessages = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                            throws IOException, ServletException {
        String name = request.getParameter("name");
        String message = request.getParameter("message");

        if (name != null && message != null) {
            myMessages.add(name + " " + message);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Iterator<String> it = myMessages.iterator();
        while(it.hasNext()) {
            String msg = it.next();
            out.println(msg); // Only print once
            System.out.println(msg); // This will go to server logs
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                            throws IOException, ServletException {
        doGet(request, response);
    }

    public static void main(String[] args) {
    }
}