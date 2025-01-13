import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.ByteBuffersDirectory;
import org.apache.lucene.store.Directory;

public class LuceneSearchExample {
    public static void main(String[] args) throws Exception {
        // Create a sample document
        Document doc = new Document();
        doc.add(new TextField("content", "This is a sample document.", Field.Store.YES));

        // Create an index writer
        Directory directory = new ByteBuffersDirectory();
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter writer = new IndexWriter(directory, config);

        // Add the document to the index
        writer.addDocument(doc);
        writer.close();

        // Search for documents containing the word "sample"
        QueryParser parser = new QueryParser("content", new StandardAnalyzer());
        Query query = parser.parse("sample");
        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(directory));
        TopDocs results = searcher.search(query, 10);

        // Print the search results
        ScoreDoc[] hits = results.scoreDocs;
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = searcher.doc(hits[i].doc);
            System.out.println(hitDoc.get("content"));
        }
    }
}