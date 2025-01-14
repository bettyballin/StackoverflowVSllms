import java.lang.String;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = "Hello, World!"; // Text to be drawn on image
        BufferedImage bufferedImage = new BufferedImage(400, 250, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawString(text, 50, 100); // Draw text on the image
        g2d.dispose();

        response.setContentType("image/png");
        java.io.OutputStream output = response.getOutputStream();
        javax.imageio.ImageIO.write(bufferedImage, "png", output);
        output.close();
    }

	public static void main(String[] args) {
	}
}