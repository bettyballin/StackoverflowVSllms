import org.apache.poi.xwpf.usermodel.XWPFDocument; // Apache POI library classes
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.FileOutputStream; // For file output
import java.io.FileNotFoundException;
import java.io.IOException;

public class WordDocumentCreator {
    public void createWordDocument() throws IOException, InvalidFormatException {   // The type of exceptions this method could throw – IO & POI.
        XWPFDocument document = new XWPFDocument();                     // Create a blank Document object
        XWPFParagraph paragraphOne = document.createParagraph();        // A Paragraph is a chunk of text within a Body. Hence we create a "paragraph one"
        XWPFRun runText = paragraphOne.createRun();      // A Run is the content of a paragraph, which can be: text, tab, page break etc...
        runText.setText("Your Text Goes Here...");                       // We set our text as usual.
        try {
            FileOutputStream outStream;                    // File Stream to write and also create (if not exists) in this case Word file at specified location with its name "first_word.docx".
            outStream = new FileOutputStream("first_word.docx");          // The path can be modified according to need.
            document.write(outStream);                     // Writes the file, flush and close the output stream.
            outStream.close();
            System.out.println("Word doc has been created Successfully....");        // Print statement after creating your Word document successfully.
        } catch (FileNotFoundException e) {
            System.err.print(e);                           // In case of exceptions, program control will land into this exception block.
        }
    }

    public static void main(String[] args) {
    }
}