import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.DifferenceEvaluator;
import org.xmlunit.diff.Comparison;
import org.xmlunit.diff.ComparisonResult;

public class XMLComparator {
    public static void main(String[] args) {
        String expectedXML = "<root><element>value</element></root>";
        String actualXML = "<root>\n<element>value</element>\n</root>";

        Diff myDiff = DiffBuilder.compare(expectedXML).withTest(actualXML)
                .withDifferenceEvaluator(new IgnoreWhitespaceDifferenceEvaluator())
                .ignoreComments()
                .ignoreWhitespace()
                .build();

        System.out.println("Similar: " + !myDiff.hasDifferences());
        if (myDiff.hasDifferences()) {
            System.out.println(myDiff.toString());
        }
    }

    public static class IgnoreWhitespaceDifferenceEvaluator implements DifferenceEvaluator {
        @Override
        public ComparisonResult evaluate(Comparison comparison, ComparisonResult outcome) {
            // Implement your custom logic to ignore whitespace differences if needed
            return ComparisonResult.EQUAL;
        }
    }
}