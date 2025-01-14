import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/chartServlet")
public class ChartServlet_2 extends HttpServlet {

    private transient List<CategoryDataset> datasets; // Store temporarily

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String[] metrics = request.getParameterValues("metrics");
        String[] fileNames = request.getParameterValues("files");

        List<CategoryDataset> results = new ArrayList<>();
        DMCalc calculator = new DMCalc(metrics, fileNames);
        calculator.calculateResults();
        results.add(calculator.getEditDistanceDataset());
        results.add(calculator.getSimilarityDataset());
        results.add(calculator.getTimeChartDataset());

        datasets = results; // Store for later use in doGet

        response.sendRedirect("metricResult.jsp"); // Use redirect to ensure GET request
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (datasets == null || datasets.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "No chart data available.");
            return;
        }

        CategoryDataset dataset = datasets.get(0); // Modify as needed for multiple datasets
        JFreeChart chart = ChartFactory.createBarChart("Sample", "Category", "Value", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        response.setContentType("image/png");
        ChartUtils.writeChartAsPNG(response.getOutputStream(), chart, 800, 600);
    }

    public static void main(String[] args) {
    }
}