import java.lang.String;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/comet")
public class CometServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Connection", "keep-alive");

        try (var writer = response.getWriter()) {
            for (int i = 0; i < 10; i++) { // Just an example loop
                writer.write("<p>Chunk #" + i + "</p>");
                writer.flush(); // Important: Flush the stream to send data immediately to the client
                Thread.sleep(2000); // Simulate long processing or delayed response
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

	public static void main(String[] args) {
	}
}