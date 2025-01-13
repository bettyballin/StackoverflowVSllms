import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

public class Main_152 {
    public static void main(String[] args) throws IOException {
        // Create an index reader
        Directory directory = FSDirectory.open(Paths.get("path_to_your_index"));
        IndexReader indexReader = DirectoryReader.open(directory);

        // Create a profiler
        Profiler profiler = new Profiler();

        // Execute a search query
        Query query = new TermQuery(new org.apache.lucene.index.Term("field", "term"));
        IndexSearcher searcher = new IndexSearcher(indexReader);
        TopDocs results = searcher.search(query, 10);

        // Profile the search execution time
        profiler.start("search");
        results = searcher.search(query, 10);
        profiler.stop("search");

        // Print the profiling results
        System.out.println(profiler.getResults());

        // Close the index reader and directory
        indexReader.close();
        directory.close();
    }
}

class Profiler {
    private long startTime;
    private String label;

    public void start(String label) {
        this.label = label;
        this.startTime = System.currentTimeMillis();
    }

    public void stop(String label) {
        if (!this.label.equals(label)) {
            throw new RuntimeException("Invalid label");
        }
        long endTime = System.currentTimeMillis();
        System.out.println(label + ": " + (endTime - startTime) + "ms");
    }

    public String getResults() {
        return label + ": " + (System.currentTimeMillis() - startTime) + "ms";
    }
}