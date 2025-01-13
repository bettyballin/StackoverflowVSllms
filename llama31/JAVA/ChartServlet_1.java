import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;

public class ChartGenerator {

    public static void main(String[] args) throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series 1", "Category 1");
        dataset.addValue(20, "Series 1", "Category 2");

        JFreeChart chart = ChartFactory.createLineChart("My Chart", "Category", "Value", dataset);
        ChartUtils.saveChartAsPNG(new File("chart.png"), chart, 400, 300);
    }
}