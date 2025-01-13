import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

public class LuceneIndexer {

    public static void main(String[] args) {
        // Create a directory
        Directory directory;
        try {
            directory = FSDirectory.open(Paths.get("lucene_index"));

            // Create an analyzer
            Analyzer analyzer = new StandardAnalyzer();

            // Create an IndexWriter
            IndexWriterConfig config = new IndexWriterConfig(analyzer);
            IndexWriter writer = new IndexWriter(directory, config);

            // Create a document
            Document document = new Document();
            document.add(new TextField("name", "Example Product", Field.Store.YES));
            document.add(new TextField("description", "This is an example product.", Field.Store.YES));

            // Add the document to the index
            writer.addDocument(document);

            // Close the IndexWriter
            writer.close();
        } catch (IOException e) {
            System.out.println("Error indexing document: " + e.getMessage());
        }
    }
}