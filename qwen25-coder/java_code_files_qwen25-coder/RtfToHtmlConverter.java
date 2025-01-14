import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class RtfToHtmlConverter {
    public static void main(String[] args) throws Exception {
        DefaultOfficeManagerConfiguration config = new DefaultOfficeManagerConfiguration();
        OfficeManager officeManager = config.buildOfficeManager();
        officeManager.start();

        OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
        InputStream inDocStream = new FileInputStream(new File("input.rtf"));
        OutputStream outHTMLStream = new FileOutputStream(new File("output.html"));

        converter.convert(inDocStream, "rtf", outHTMLStream, "html");

        officeManager.stop();

        // Optionally, clean up the HTML output to be more email-friendly.
    }
}