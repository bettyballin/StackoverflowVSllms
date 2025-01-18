import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class SimpleSearch {
    public static void main(String[] args) throws Exception {
        Path indexDir = Files.createTempDirectory("demo");
        Directory dir = FSDirectory.open(indexDir);
        Analyzer analyzer = new StandardAnalyzer();

        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(dir, iwc);

        // Assuming docs is an array/list of Path objects pointing to your documents.
        Path[] docs = new Path[]{
            Paths.get("doc1.txt"),
            Paths.get("doc2.txt")
        };
        createSampleDocs(docs);

        for (Path file : docs) {
            Document document = convertFileToDocument(file);
            writer.addDocument(document);
        }

        writer.close();

        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);

        // This wraps up all of our user-facing interactions, such as accepting inputs and displaying results.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a term to find:");
        String searchTerm = scanner.nextLine();

        Query q = parseQuery("contents", searchTerm, analyzer);
        // Run the actual search and display the results.
        printSearchResults(q, searcher);

        reader.close();
        dir.close();
    }

    private static void createSampleDocs(Path[] docs) throws IOException {
        Files.writeString(docs[0], "This is the content of the first document.");
        Files.writeString(docs[1], "This is the content of the second document.");
    }

    private static Document convertFileToDocument(Path file) throws IOException {
        Document doc = new Document();
        // Add the contents of the file to a field named "contents"
        String content = Files.readString(file);
        doc.add(new TextField("contents", content, Field.Store.YES));
        // Also, add the filename as a field
        doc.add(new StringField("path", file.toString(), Field.Store.YES));
        return doc;
    }

    private static Query parseQuery(String field, String queryString, Analyzer analyzer) throws ParseException {
        QueryParser parser = new QueryParser(field, analyzer);
        return parser.parse(queryString);
    }

    private static void printSearchResults(Query query, IndexSearcher searcher) throws IOException {
        TopDocs results = searcher.search(query, 10);
        ScoreDoc[] hits = results.scoreDocs;
        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("path") + "\t" + d.get("contents"));
        }
    }
}