import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String text = "Hello, World!";
        BufferedImage image = generateImage(text);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", bos);
        byte[] imageData = bos.toByteArray();
        response.setContentType("image/png");
        response.getOutputStream().write(imageData);
    }

    private BufferedImage generateImage(String text) {
        // Generate the image using your preferred method
        // For example, using Graphics2D
        BufferedImage image = new BufferedImage(200, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.drawString(text, 10, 20);
        g2d.dispose();
        return image;
    }

    public static void main(String[] args) {
    }
}