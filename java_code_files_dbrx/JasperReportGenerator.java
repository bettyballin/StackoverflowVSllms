import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReportGenerator {
    // Example JasperReports Java code
    private void callJasperReport() {
        try {
            Connection con = getDBConnection(); // connect to your database here
            String absoluteUrl = "/home/local/user/testreport";
            File reportFile = new File(absoluteUrl, "Test Report.jasper"); // path of jasper file (compiled report)
            Map<String, Object> map = new HashMap<>();
            JasperPrint print = JasperFillManager.fillReport(reportFile.getPath(), map, con);
            JasperViewer view = new JasperViewer(print, false); // use true on your application
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(JasperReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Connection getDBConnection() {
        // Implement your database connection here
        return null;
    }

    public static void main(String[] args) {
    }
}