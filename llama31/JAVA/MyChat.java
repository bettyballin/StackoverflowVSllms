import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyChat extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ArrayList<String> myMessages = new ArrayList<String>();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String input = request.getReader().readLine();
        String[] tmp = input.split(",");
        myMessages.add(tmp[0] + " " + tmp[1]);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Iterator<String> it = myMessages.iterator();
        while (it.hasNext()) {
            out.println(it.next());
            // Use a logging framework to log messages
            // Logger.getLogger(MyChat.class.getName()).info(it.next());
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // You can handle GET requests differently if needed
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    public static void main(String[] args) {
    }
}