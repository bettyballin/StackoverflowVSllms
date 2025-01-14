import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DocxToHtmlConverter {

    public static void main(String[] args) throws IOException, XDocReportException {
        // Load ODT file by filling the report registry
        InputStream in = DocxToHtmlConverter.class.getResourceAsStream("WordTemplate.docx");
        IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);

        // Create context Java model
        FileOutputStream out = new FileOutputStream(new File("output.html"));

        // Apply registered template engine to transform the ODT into a Html
        report.process(null, out);

        System.out.println("File converted!");
    }
}

class XDocReportException extends Exception {}

interface IXDocReport {
    void process(Object context, FileOutputStream out) throws XDocReportException;
}

class XDocReportRegistry {
    private static XDocReportRegistry instance = new XDocReportRegistry();

    public static XDocReportRegistry getRegistry() {
        return instance;
    }

    public IXDocReport loadReport(InputStream in, TemplateEngineKind kind) {
        return new IXDocReport() {
            public void process(Object context, FileOutputStream out) throws XDocReportException {
                // Implement processing logic here
            }
        };
    }
}

enum TemplateEngineKind {
    Velocity
}