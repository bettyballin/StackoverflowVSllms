import java.lang.String;
import java.io.*;
import javax.servlet.http.*;
import java.util.Random;

public class RandomNumberServlet extends HttpServlet {
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
      int randomNumber = new Random().nextInt((100 - 1) + 1) + 1; // generates a number between 1 and 100 inclusively.
      PrintWriter out = res.getWriter();
      out.println(randomNumber);
   }

	public static void main(String[] args) {
	}
}