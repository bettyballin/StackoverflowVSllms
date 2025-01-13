import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main_251 {
    public static void main(String[] args) throws IOException {
        // assume 'file' is a File object representing the uploaded file
        File file = new File("path_to_your_file"); // replace with your file path
        Document doc = new Document();
        byte[] fileContents = Files.readAllBytes(file.toPath());
        doc.setFileContents(fileContents);
        // persist the document using your EJB
        System.out.println("File contents read and set to Document object.");
    }

    static class Document {
        private byte[] fileContents;

        public void setFileContents(byte[] fileContents) {
            this.fileContents = fileContents;
        }
    }
}