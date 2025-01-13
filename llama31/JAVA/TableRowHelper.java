import java.lang.String;
import java.lang.Set;

// Added missing imports
import org.directwebremoting.util.Util;
import org.directwebremoting.util.Session;
import org.directwebremoting.options.Options;

public class TableRowHelper {
    // Added getSessionForPage() method, assuming it's a custom method to get the session for the page
    private static Session getSessionForPage() {
        // Replace this with your actual implementation
        return new Session();
    }

    public static void addRows(String tableBdId, String[][] data) {
        Util dwrUtil = new Util(getSessionForPage()); // Get all page sessions
        Options options = new Options();
        options.setId("myTdId_{row}_{cell}"); // Set the ID of each TD element
        dwrUtil.addRows(tableBdId, data, options);
    }

    public static void main(String[] args) {
    }
}