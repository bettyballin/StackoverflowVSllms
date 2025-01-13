import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriterConfig;

public class LuceneConfigExample {
    public static void main(String[] args) {
        // Assuming 'analyzer' is defined somewhere in your code.
        // For demonstration, a default analyzer is used here.
        Analyzer analyzer = new org.apache.lucene.analysis.standard.StandardAnalyzer();

        // Example indexing configuration
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        config.setRAMBufferSizeMB(512); // Adjust buffer size for better performance

        System.out.println("RAM Buffer Size: " + config.getRAMBufferSizeMB());
    }
}