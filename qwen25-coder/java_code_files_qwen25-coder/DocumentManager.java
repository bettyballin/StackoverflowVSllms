import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DocumentManager {
    public static void main(String[] args) throws Exception {
        File dbFile = new File("documents.yap");
        ObjectContainer db = Db4oEmbedded.openFile(dbFile.getAbsolutePath());

        // Store a PDF document
        File pdfFile = new File("example.pdf");
        Document doc = new Document(pdfFile.getName(), readFileBytes(pdfFile));
        db.store(doc);
        db.commit();

        // Retrieve and save the PDF document
        ObjectSet<Document> result = db.queryByExample(new Document(pdfFile.getName(), null));
        if (result.hasNext()) {
            Document retrievedDoc = result.next();
            writeFileBytes("retrieved_" + retrievedDoc.name, retrievedDoc.data);
        }

        db.close();
    }

    static byte[] readFileBytes(File file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        fis.read(bytes);
        fis.close();
        return bytes;
    }

    static void writeFileBytes(String filename, byte[] bytes) throws Exception {
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(bytes);
        fos.close();
    }
}

class Document {
    String name;
    byte[] data;

    public Document(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }
}