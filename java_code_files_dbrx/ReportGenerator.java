import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.report.JasperReportBuilder;
import java.io.FileOutputStream;

public class ReportGenerator {
    public static void main(String[] args) {
        JasperReportBuilder report = DynamicReports.report(); // or crosstab, adhoc, etc
        // set your table details and data here (depending on the complexity of your task)
        try {
            report.toPdf(new FileOutputStream("table_report.pdf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}