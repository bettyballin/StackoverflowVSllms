import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import java.nio.file.Paths;

public class LuceneIndexer {
    public static void main(String[] args) throws Exception {
        // Open a new IndexWriter, specifying the standard analyzer and Directory:
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter writer = new IndexWriter(getDirectory(), config);

        // Store fields using an index-and-store both approach for retrieval purposes:
        Document doc = new Document();
        doc.add(new TextField("title", "a document title", Field.Store.YES));  // Field is stored and searchable/tokenized
        doc.add(new StringField("id", "ID001", Field.Store.YES));             // Unique identifier, not tokenized or included in searches
        writer.addDocument(doc);

        writer.close();
    }

    private static Directory getDirectory() throws Exception {
        return FSDirectory.open(Paths.get("indexDir"));
    }
}