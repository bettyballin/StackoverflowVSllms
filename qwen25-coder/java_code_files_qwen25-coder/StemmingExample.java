// Java example using Snowball stemmer from Apache Lucene
import org.apache.lucene.analysis.snowball.SnowballFilter;
import org.tartarus.snowball.ext.EnglishStemmer;

public class StemmingExample {
    public static void main(String[] args) throws Exception {
        EnglishStemmer stemmer = new EnglishStemmer();
        String words[] = {"parse", "parser", "parsing"};
        
        for (String word : words) {
            stemmer.setCurrent(word);
            if (stemmer.stem()) {
                System.out.println(stemmer.getCurrent() + ",");
            }
        }
    }
}