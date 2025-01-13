import java.io.ByteArrayOutputStream;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class Main_106 {
    public static void main(String[] args) {
        // Create a blobstore service
        BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

        // Assuming targetChart is a JFreeChart object
        JFreeChart targetChart = new JFreeChart("Title", null); // Create a new chart
        String info = "Chart Info"; // Replace with your actual info

        // Create a byte array output stream to store the image data
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Save the chart as PNG to the output stream
        try {
            ChartUtilities.saveChartAsPNG(outputStream, targetChart, 600, 400, info);
        } catch (Exception e) {
            System.out.println("Error saving chart as PNG: " + e.getMessage());
        }

        // Get the byte array from the output stream
        byte[] imageData = outputStream.toByteArray();

        // Create a new blob and store the image data
        BlobKey blobKey = blobstoreService.createBlob(imageData);

        // Get the URL of the blob
        String imageUrl = blobstoreService.serve(blobKey, "image/png");

        // Display the image in the JSP
        // Note: This is not directly possible in a Java main method. 
        // You would typically use a servlet or JSP to display the image in a web application.
        System.out.println("Image URL: " + imageUrl);
    }
}