import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ImageServlet.java
@WebServlet("/images/*")
public class ImageServlet_1_1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imagePath = req.getRequestURI().substring(req.getContextPath().length());
        File imageFile = new File(getServletContext().getRealPath(imagePath));
        if (imageFile.exists()) {
            // serve the image
        } else {
            // serve a default image
        }
    }

    public static void main(String[] args) {
    }
}