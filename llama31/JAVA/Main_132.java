import org.docx4j.Docx4J;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

/**
 * This program converts a Word document (.docx) to a PDF file using the docx4j library.
 * 
 * To compile and run this program, ensure you have the docx4j library in your classpath.
 * You can download the docx4j library from https://www.docx4java.org/downloads.html.
 * 
 * Compilation example (assuming the library is in the same directory as your java file):
 *   javac -cp ".;docx4j-11.4.5.jar" Main.java
 * 
 * Execution example (after successful compilation):
 *   java -cp ".;docx4j-11.4.5.jar" Main
 */
public class Main_132 {
    public static void main(String[] args) throws Exception {
        // Load the Word document
        WordprocessingMLPackage wordMLPackage = Docx4J.load("input.docx");

        // Save the PDF
        Docx4J.toPDF(wordMLPackage, "output.pdf");
    }
}