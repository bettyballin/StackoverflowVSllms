import java.lang.String;
// Java example using Stanford CoreNLP's StemmerAnnotator
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.Properties;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class StanfordStemming {
    public static void main(String[] args) throws IOException, TimeoutException {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma");
        
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        
        Annotation document = new Annotation("parsing parser parse");
        pipeline.annotate(document);
        
        for (CoreLabel token : document.get(CoreAnnotations.TokensAnnotation.class)) {
            String word = token.word();
            String stem = token.lemma(); // Note: lemma is used as a proxy to the stem
            System.out.println(word + " -> " + stem);
        }
    }
}