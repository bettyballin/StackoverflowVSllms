import com.sun.star.beans.PropertyValue;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;

public class ImportCSV {
    public static void main(String[] args) {
        try {
            // Get the remote component context
            XComponentContext xComponentContext = Bootstrap.bootstrap();
            XMultiComponentFactory xMCF = xComponentContext.getServiceManager();

            // Create a new instance of LibreOffice Desktop
            Object desktop = xMCF.createInstanceWithContext("com.sun.star.frame.Desktop", xComponentContext);
            XComponentLoader xComponentLoader = UnoRuntime.queryInterface(XComponentLoader.class, desktop);

            // Define the URL for the CSV file
            String csvUrl = "file:///path/to/your/file.csv";

            // Define properties to use the CSV filter
            PropertyValue[] loadProps = new PropertyValue[3];
            loadProps[0] = new PropertyValue();
            loadProps[0].Name = "FilterName";
            loadProps[0].Value = "Text - txt - csv (StarCalc)"; // Use this for CSV files

            loadProps[1] = new PropertyValue();
            loadProps[1].Name = "Overwrite";
            loadProps[1].Value = Boolean.TRUE;

            loadProps[2] = new PropertyValue();
            loadProps[2].Name = "Hidden";
            loadProps[2].Value = Boolean.TRUE; // Make the document hidden

            // Load the CSV file
            xComponentLoader.loadComponentFromURL(csvUrl, "_blank", 0, loadProps);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Bootstrap {
        public static XComponentContext bootstrap() throws Exception {
            final String oooExeFolder = "path/to/libreoffice/program"; // Adjust this path
            String unoUrl = "uno:socket,host=localhost,port=2002;urp;StarOffice.ComponentContext";
            final java.lang.Process process = Runtime.getRuntime().exec(oooExeFolder + "/soffice --accept=\"" + unoUrl + "\" --headless");
            XComponentContext xLocalContext = com.sun.star.comp.helper.Bootstrap.bootstrap();
            return xLocalContext;
        }
    }
}