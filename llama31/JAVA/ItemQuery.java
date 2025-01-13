import java.lang.String;

public class ItemQuery {
    String query = "SELECT color, pattern, size, " +
                   "manufacturer, mfgSku, storeLocation, " +
                   "aisle, status " +
                   "FROM tblItems WHERE ourSku = ?";

    public static void main(String[] args) {
        // Create an instance of the class to avoid compiler warning
        ItemQuery itemQuery = new ItemQuery();
    }
}