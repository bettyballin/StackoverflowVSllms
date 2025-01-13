import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;

public class ChartServlet extends HttpServlet {
    private List<CategoryDataset> datasets = new ArrayList<>();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Generate datasets based on user input
        String[] metrics = request.getParameterValues("metrics");
        String[] fileNames = request.getParameterValues("files");
        DMCalc calculator = new DMCalc(metrics, fileNames);
        calculator.calculateResults();
        datasets.add(calculator.getEditDistanceDataset());
        datasets.add(calculator.getSimilarityDataset());
        datasets.add(calculator.getTimeChartDataset());

        request.setAttribute("datasets", datasets);
        RequestDispatcher view = request.getRequestDispatcher("metricResult.jsp");
        view.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int datasetIndex = Integer.parseInt(request.getParameter("datasetIndex"));
        CategoryDataset dataset = datasets.get(datasetIndex);

        // Generate chart
        JFreeChart chart = ChartFactory.createLineChart("Chart Title", "X Axis", "Y Axis", dataset);

        // Write chart to response output stream as PNG
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        ChartUtilities.writeChartAsPNG(out, chart, 400, 300);
        out.close();
    }

    public static void main(String[] args) {
    }
}