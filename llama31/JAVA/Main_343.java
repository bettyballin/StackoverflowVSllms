import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.IOException;

public class Main_343 {
    public static void main(String[] args) throws IOException {
        // Create a sample dataset
        XYSeries series = new XYSeries("Sample Data");
        series.add(1, 2);
        series.add(2, 4);
        series.add(3, 6);
        XYDataset data = new XYSeriesCollection(series);

        JFreeChart chart = ChartFactory.createLineChart("Chart Title", "X Axis", "Y Axis", data);
        File file = new File("chart.png");
        ChartUtilities.saveChartAsPNG(file, chart, 500, 300);
        // Send the chart image to the client
        System.out.println("Chart saved to chart.png");
    }
}