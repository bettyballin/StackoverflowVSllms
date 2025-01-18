import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.ServletOutputStream;

// JFreeChart imports
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartServlet extends HttpServlet {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String chartType = request.getParameter("chartType");

        // Retrieve the corresponding CategoryDataset based on the chart type
        CategoryDataset dataset = getDataset(chartType);

        // Create and configure JFreeChart object using the retrieved dataset
        JFreeChart chart = ChartFactory.createBarChart(
            "Chart Title",     // chart title
            "Category",        // domain axis label
            "Value",           // range axis label
            dataset            // data
        );
        // Customize chart appearance, layout, title, etc., if necessary

        // Set response headers for PNG image output
        response.setContentType("image/png");
        ServletOutputStream out = response.getOutputStream();

        try {
            ChartUtilities.writeChartAsPNG(out, chart, WIDTH, HEIGHT);
        } finally {
            out.close();
        }
    }

    private CategoryDataset getDataset(String chartType) {
        // Implement dataset retrieval based on chartType
        // For example purposes, returning a sample dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "Series1", "Category1");
        dataset.addValue(4, "Series1", "Category2");
        dataset.addValue(3, "Series1", "Category3");
        return dataset;
    }
}