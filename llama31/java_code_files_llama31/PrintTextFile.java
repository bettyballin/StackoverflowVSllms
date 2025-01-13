/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.JobSheets;

public class PrintTextFile {
    public static void printTextFile(File file, String string) throws PrintException {
        if (!file.exists()) {
            throw new PrintException("File to print does not exist (" + file.getAbsolutePath() + ") !");
        }
        PrintService printService = PrintTextFile.getPrintService(string);
        HashPrintRequestAttributeSet hashPrintRequestAttributeSet = new HashPrintRequestAttributeSet();
        hashPrintRequestAttributeSet.add(new JobName(file.getName(), null));
        hashPrintRequestAttributeSet.add(JobSheets.NONE);
        DocPrintJob docPrintJob = printService.createPrintJob();
        try (FileInputStream fileInputStream = new FileInputStream(file);){
            SimpleDoc simpleDoc = new SimpleDoc(fileInputStream, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
            docPrintJob.print(simpleDoc, hashPrintRequestAttributeSet);
        }
        catch (IOException iOException) {
            throw new PrintException("Error printing file: " + iOException.getMessage());
        }
        try {
            Thread.sleep(5000L);
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    private static PrintService getPrintService(String string) {
        PrintService[] printServiceArray;
        for (PrintService printService : printServiceArray = PrintServiceLookup.lookupPrintServices(null, null)) {
            if (!printService.getName().equals(string)) continue;
            return printService;
        }
        return null;
    }

    public static void main(String[] stringArray) {
        File file = new File("path_to_your_text_file.txt");
        String string = "your_printer_name";
        try {
            PrintTextFile.printTextFile(file, string);
        }
        catch (PrintException printException) {
            System.out.println(printException.getMessage());
        }
    }
}
