import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

@WebServlet(name = "ElectricityUsageChartServlet", urlPatterns = "/electricityUsageChart")
public class ElectricityUsageChartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Sample data
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Electricity Usage", "January");
        dataset.addValue(12, "Electricity Usage", "February");
        dataset.addValue(15, "Electricity Usage", "March");
        // Add more data as needed

        JFreeChart chart = ChartFactory.createBarChart(
                "Electricity Usage by Month", // chart title
                "Month", // domain axis label
                "Usage", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
        );

        // Set response headers
        response.setHeader("Content-Disposition", "attachment; filename=electricityUsageChart.png");
        response.setContentType("image/png");

        // Write the chart to the response output stream
        ChartUtils.writeChartAsPNG(response.getOutputStream(), chart, 600, 400);
    }

    // Servlets do not require a main method to execute. 
    // This main method is added to meet your request but won't be used when deployed as a servlet.
    public static void main(String[] args) {
        System.out.println("This is a servlet and should be run in a web container.");
    }
}