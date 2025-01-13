import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.JobSheets;

public class PrintTextFile {

    public static void printTextFile(File file, String printerName) throws PrintException {
        // Check if file exists
        if (!file.exists()) {
            throw new PrintException("File to print does not exist (" + file.getAbsolutePath() + ") !");
        }

        // Get the print service
        PrintService printService = getPrintService(printerName);

        // Create a print request attribute set
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        pras.add(new JobName(file.getName(), null));
        pras.add(JobSheets.NONE);

        // Create a print job
        DocPrintJob printJob = printService.createPrintJob();

        // Create a document
        try (InputStream is = new FileInputStream(file)) {
            Doc doc = new SimpleDoc(is, DocFlavor.INPUT_STREAM.AUTOSENSE, null);

            // Print the document
            printJob.print(doc, pras);
        } catch (IOException e) {
            throw new PrintException("Error printing file: " + e.getMessage());
        }

        // Wait for the print job to finish
        try {
            Thread.sleep(5000); // wait for 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static PrintService getPrintService(String printerName) {
        // Get the list of available print services
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);

        // Find the print service with the specified name
        for (PrintService printService : printServices) {
            if (printService.getName().equals(printerName)) {
                return printService;
            }
        }

        // If no print service is found, return null
        return null;
    }

    public static void main(String[] args) {
        File file = new File("path_to_your_text_file.txt");
        String printerName = "your_printer_name";

        try {
            printTextFile(file, printerName);
        } catch (PrintException e) {
            System.out.println(e.getMessage());
        }
    }
}