import java.lang.String;

import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;
import com.crystaldecisions.sdk.occa.report.exportoptions.ExportOptions;
import com.crystaldecisions.sdk.occa.report.exportoptions.ExportFormatType;
import com.crystaldecisions.sdk.occa.report.exportoptions.PdfExportFormatOptions;

public class ReportExporter {
    // In Java-like pseudocode, assuming you have access to the configuration settings programmatically.
    public static void main(String[] args) {
        ReportClientDocument reportClientDoc = new ReportClientDocument();
        // Assuming dataSourceConnections is defined elsewhere or obtained through configuration
        Object dataSourceConnections = null; // Placeholder for actual data source connections
        reportClientDoc.setDataSourceConnections(dataSourceConnections);

        ExportOptions exportOptions = new ExportOptions();
        PdfExportFormatOptions pdfExportOptions = new PdfExportFormatOptions();
        pdfExportOptions.setEmbedFont(true);
        exportOptions.setExportFormatType(ExportFormatType.PDF);
        exportOptions.setFormatOptions(pdfExportOptions);
    }
}