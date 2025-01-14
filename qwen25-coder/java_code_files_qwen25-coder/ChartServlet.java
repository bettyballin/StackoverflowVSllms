import java.lang.String;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.data.general.DefaultPieDataset;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Assuming targetChart and info are defined somewhere
        // JFreeChart targetChart = ...;
        // ChartRenderingInfo info = ...;

        DefaultPieDataset dataset = new DefaultPieDataset();
        JFreeChart targetChart = ChartFactory.createPieChart("Title", dataset, true, true, false);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ChartUtilities.writeChartAsPNG(outputStream, targetChart, 600, 400);

        response.setContentType("image/png");
        response.setContentLength(outputStream.size());

        response.getOutputStream().write(outputStream.toByteArray());
    }

    public static void main(String[] args) {
    }
}