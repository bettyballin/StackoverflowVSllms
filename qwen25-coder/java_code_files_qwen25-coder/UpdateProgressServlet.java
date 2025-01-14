import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import org.json.JSONObject;

@WebServlet("/api/update-progress")
public class UpdateProgressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Read JSON body
            String body = servletRequestToString(request);
            JSONObject jsonBody = new JSONObject(body);

            double time = jsonBody.getDouble("time");
            String videoId = jsonBody.getString("videoId");

            // Here you would save the progress to a database, associated with user and video ID.
            saveProgress(time, videoId, getUsernameFromSession(request));

            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while updating your progress.");
        }
    }

    private void saveProgress(double time, String videoId, String username) {
        // Database code to store the progress
    }

    private String servletRequestToString(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } finally {
            reader.close();
        }
        return sb.toString();
    }

    private String getUsernameFromSession(HttpServletRequest request) {
        // Retrieve username from session or authentication system
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new SecurityException("User not logged in");
        }
        return (String) session.getAttribute("username");
    }

    public static void main(String[] args) {
    }
}