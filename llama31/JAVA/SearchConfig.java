import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;

public class SearchConfig {
    // Example analyzer configuration
    Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_8_11_1);

    public static void main(String[] args) {
    }
}