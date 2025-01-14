import java.lang.String;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.nio.file.Paths;

public class DocumentIndexer {
    public static void indexDocument(String path, String content) throws Exception {
        File file = new File(path);
        Directory directory = FSDirectory.open(Paths.get(file.getParent()));
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        try (IndexWriter writer = new IndexWriter(directory, config)) {
            Document doc = new Document();
            String filename = file.getName();
            doc.add(new StringField("filename", filename, Field.Store.YES));
            doc.add(new TextField("content", content, Field.Store.YES));
            writer.addDocument(doc);
        }
    }

    public static void main(String[] args) {
    }
}