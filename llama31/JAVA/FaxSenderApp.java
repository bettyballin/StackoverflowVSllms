import com.javafax.FaxSender;

public class FaxSenderApp {
    public static void main(String[] args) {
        // Load the PCL file
        FaxSender sender = new FaxSender("output.pcl");

        // Send the fax
        sender.sendFax("fax_number");
    }
}