import java.io.ByteArrayOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

public class ChartImageWriter {

    HttpServletResponse response = null;
    JFreeChart targetChart = null;

    {
        ServletOutputStream output = response.getOutputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ChartUtilities.writeChartAsPNG(baos, targetChart, 600, 400);
        byte[] imageData = baos.toByteArray();
    }

    public static void main(String[] args) {
    }
}