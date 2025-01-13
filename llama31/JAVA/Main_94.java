import javax.print.PrintService;
import javax.print.PrintServiceAttributeSet;
import javax.print.PrintServiceLookup;
import javax.print.attribute.standard.PrinterName;
import javax.print.attribute.HashPrintServiceAttributeSet;

public class Main_94 {
    public static void main(String[] args) {
        PrintServiceAttributeSet attributes = new HashPrintServiceAttributeSet();
        attributes.add(new PrinterName("*", null)); // retrieve all printers

        PrintService[] printerServices = PrintServiceLookup.lookupPrintServices(null, attributes);
        
        // Print the list of printers for verification
        for (PrintService service : printerServices) {
            System.out.println(service.getName());
        }
    }
}