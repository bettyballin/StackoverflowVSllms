import java.lang.String;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.Directory;

import java.nio.file.Paths;

public class DocumentSearcher {
    public static void search(String indexPath, String queryString) throws Exception {
        Directory directory = FSDirectory.open(Paths.get(indexPath));
        try (DirectoryReader ireader = DirectoryReader.open(directory)) {
            IndexSearcher searcher = new IndexSearcher(ireader);
            QueryParser parser = new QueryParser("content", new StandardAnalyzer());
            Query query = parser.parse(queryString);
            TopDocs topDocs = searcher.search(query, 10);
            for (ScoreDoc sd : topDocs.scoreDocs) {
                Document d = searcher.doc(sd.doc);
                System.out.println(d.get("filename"));
            }
        }
    }

    public static void main(String[] args) {
    }
}