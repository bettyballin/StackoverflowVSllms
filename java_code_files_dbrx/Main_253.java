import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Paragraph> paragraphs = new ArrayList<>();
        // Add a sample paragraph
        paragraphs.add(new Paragraph());
        // Get the first paragraph's text content
        paragraphs.get(0).text(); // Get the first paragraph's text content
    }

    static class Paragraph {
        public String text() {
            // Return the text content
            return "Sample paragraph text";
        }
    }
}