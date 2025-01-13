// Using PDF2PCL
import com.pdf2pcl.PCLConverter;

public class Main_825 {
    public static void main(String[] args) {
        // Load the PDF file
        PCLConverter converter = new PCLConverter("output.pdf");

        // Convert to PCL
        converter.convertToPCL("output.pcl");
    }
}