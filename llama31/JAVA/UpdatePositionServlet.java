import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import java.util.HashMap;
import java.util.Map;

// Assume this is the server-side code to handle the AJAX request
@WebServlet("/updatePosition")
public class UpdatePositionServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    // Get the user's ID from the session or another authentication mechanism
    String userId = (String) request.getSession().getAttribute("userId");

    // Get the updated playback position from the request
    int position = Integer.parseInt(request.getParameter("position"));

    // Store the updated playback position in a database or cache
    // For simplicity, we'll use a HashMap to store the positions
    Map<String, Integer> positions = new HashMap<>();
    positions.put(userId, position);

    // Set a cookie with the updated playback position
    Cookie cookie = new Cookie("playbackPosition", String.valueOf(position));
    cookie.setMaxAge(31536000); // Set cookie to expire in 1 year
    response.addCookie(cookie);
  }

  public static void main(String[] args) {
    // Note: This main method does not execute the doPost method.
    // To test this servlet, you would typically deploy it to a web server like Apache Tomcat.
  }
}