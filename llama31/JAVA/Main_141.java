import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main_141 {
    public static void main(String[] args) {
        // Path to the output document
        String outputPath = "path/to/document.docx";
        
        try {
            // Create a new Word document
            XWPFDocument doc = new XWPFDocument();

            // Create a new paragraph
            XWPFParagraph para = doc.createParagraph();

            // Create a new run
            XWPFRun run = para.createRun();

            // Set the text
            run.setText("#MySubjects.subject_name[q]#");

            // Set the font
            run.setFontFamily("Times New Roman");
            run.setFontSize(14);

            // Save the document
            try (FileOutputStream out = new FileOutputStream(outputPath)) {
                doc.writeTo(out);
            }
            doc.close();
            System.out.println("Document created successfully at: " + outputPath);
        } catch (IOException e) {
            System.err.println("Error creating document: " + e.getMessage());
        }
    }
}