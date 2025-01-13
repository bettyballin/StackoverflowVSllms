import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.sun.star.bridge.XUnoUrlResolver;
import com.sun.star.comp.helper.Bootstrap;
import com.sun.star.io.XInputStream;
import com.sun.star.io.XInputStreamProvider;
import com.sun.star.lang.XComponent;
import com.sun.star.sheet.XSpreadsheetDocument;
import com.sun.star.table.XCellRange;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;

public class CSVImporter {

    public static void main(String[] args) throws Exception {
        // Bootstrap OpenOffice.org
        XComponentContext context = Bootstrap.bootstrap();
        XUnoUrlResolver resolver = UnoRuntime.queryInterface(XUnoUrlResolver.class, context.getServiceManager().createInstanceWithContext("com.sun.star.bridge.UnoUrlResolver", context));

        // Load the Calc document
        XSpreadsheetDocument document = UnoRuntime.queryInterface(XSpreadsheetDocument.class,
                resolver.resolve("uno:component://OpenOffice.org/Calc/Document"));

        // Select the first sheet
        com.sun.star.sheet.XSpreadsheet sheet = document.getSheets().getByIndex(0);

        // Read the CSV file
        File csvFile = new File("path/to/your/csvfile.csv"); // Change this to your CSV file path
        FileInputStream csvStream = new FileInputStream(csvFile);
        XInputStream xInStream = UnoRuntime.queryInterface(XInputStream.class, csvStream);

        // Create a text input stream provider
        XInputStreamProvider provider = UnoRuntime.queryInterface(XInputStreamProvider.class,
                context.getServiceManager().createInstanceWithContext("com.sun.star.io.TextInputStreamProvider", context));

        // Set the input stream and encoding
        provider.setTextInputStream(xInStream, "utf-8");

        // Import the CSV into the sheet
        XCellRange cellRange = sheet.getCellRangeByName("A1"); // Starting cell
        sheet.importData(cellRange.getCellAddress(), provider.getTextInputStream());

        // Close the document and streams
        XComponent component = UnoRuntime.queryInterface(XComponent.class, document);
        component.dispose();
        csvStream.close();
    }
}