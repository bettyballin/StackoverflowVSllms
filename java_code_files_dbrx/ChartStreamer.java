import java.lang.String;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.OutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ChartStreamer {

    public static void main(String[] args) throws IOException {

        // Create targetChart
        TargetChart targetChart = new TargetChart();

        BufferedImage bufferedImage = targetChart.createBufferedImage(400, 250); // create the chart as a BufferedImage object

        // Set content type
        Response.setContentType("image/png");

        // Get output stream
        Response response = new Response();

        OutputStream outputStream = response.getOutputStream();

        // Write image to output stream
        ImageIO.write((RenderedImage)bufferedImage,"PNG",outputStream);

    }

}

class TargetChart {

    public BufferedImage createBufferedImage(int width, int height) {
        // For illustration, return a blank BufferedImage
        return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        // In a real application, this method would create and return a chart image
    }

}

class Response {

    public static void setContentType(String type) {
        // Dummy method for compilation
    }

    public OutputStream getOutputStream() {
        // Return a dummy OutputStream
        return System.out;
    }

}