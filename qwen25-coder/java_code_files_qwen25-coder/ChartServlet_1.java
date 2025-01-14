import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ChartServlet_1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Create dataset for JFreeChart
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Series 1", "Category A");
        dataset.addValue(5.0, "Series 1", "Category B");
        dataset.addValue(3.0, "Series 1", "Category C");

        // Generate a chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Sample Bar Chart",
                "Categories",
                "Value",
                dataset);

        // Create BufferedImage of the chart
        BufferedImage chartImage = chart.createBufferedImage(600, 400);

        // Get byte array of the chart image
        byte[] imageBytes = getByteArray(chartImage);

        // Set response type to PNG and write byte array to response output stream
        resp.setContentType("image/png");
        resp.getOutputStream().write(imageBytes);
    }

    private static ByteArrayOutputStream getOutputStream(BufferedImage image) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "png", os);
        return os;
    }

    private byte[] getByteArray(BufferedImage image) throws IOException {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", bos);
        byte[] bytes = bos.toByteArray();
        bos.close();
        return bytes;
    }

    public static void main(String[] args) {
    }
}