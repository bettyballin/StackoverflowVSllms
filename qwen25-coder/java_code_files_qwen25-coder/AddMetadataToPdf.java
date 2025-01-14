import java.io.File;
import java.util.Set;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

public class AddMetadataToPdf {
    public static void main(String[] args) throws Exception {
        // Load an existing document
        try (PDDocument document = PDDocument.load(new File("input.pdf"))) {

            // Get the document information object
            PDDocumentInformation info = document.getDocumentInformation();

            // Set custom metadata fields
            info.setCustomMetadataValue("MRN", "TEST000001");
            info.setCustomMetadataValue("ACCT", "TEST0000000000001");
            info.setCustomMetadataValue("DATE", "01/01/2009^16:44");
            info.setCustomMetadataValue("DOC_TYPE", "Clinical");
            info.setCustomMetadataValue("DOC_NUM", "192837475");
            info.setCustomMetadataValue("DOC_VER", "1");

            // Save the document with new metadata
            document.save("output.pdf");
        }
    }
}