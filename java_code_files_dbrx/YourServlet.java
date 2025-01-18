import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/your-servlet")
public class YourServlet extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String button1 = request.getParameter("button1"); // it will be "Submit 1" if this button is clicked
       String button2 = request.getParameter("button2"); // it will be "Submit 2" if this button is clicked
       // Now check which one was sent by the form
       if(button1 != null && !button1.isEmpty()){
           System.out.println("Button 1 pressed.");
       }else if (button2 != null && !button2.isEmpty()) {
           System.out.println("Button 2 pressed");
       } else {
         System.err.println("Unknown button triggered!");
      }
   }

    public static void main(String[] args) {
    }
}