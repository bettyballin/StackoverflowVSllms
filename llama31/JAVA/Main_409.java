import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.List;

class MyBean {
    // Define the properties and methods of your bean
}

public class Main_409 {
    public static void main(String[] args) throws Exception {
        // Create a data source
        List<MyBean> data = new ArrayList<>();
        // Add data to the list...

        // Compile the report
        JasperReport report = JasperCompileManager.compileReport("report.jrxml");

        // Fill the report with data
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(data));

        // Export the report to PDF
        JasperExportManager.exportReportToPdfFile(print, "report.pdf");
    }
}