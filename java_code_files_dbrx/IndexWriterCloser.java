import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;

public class Example {
    public static void main(String[] args) throws Exception {
        // Create an instance of IndexWriter
        Directory directory = new RAMDirectory();
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter writer = new IndexWriter(directory, config);

        // Commit changes and wait pending operations if any. This also triggers automatic merge of dirty index segments:
        writer.commit();
        writer.close(); // this is very important! don't forget to call it once you are done populating your index
    }
}