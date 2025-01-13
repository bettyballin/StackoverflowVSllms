import java.text.BreakIterator;
import java.util.Locale;

public class Main_518 {
    public static void main(String[] args) {
        String text = "This is a long piece of text that needs to be wrapped.";
        String wrappedText = wrapText(text, 20);
        System.out.println(wrappedText);
    }

    public static String wrapText(String text, int width) {
        BreakIterator boundary = BreakIterator.getLineInstance(Locale.US);
        boundary.setText(text);

        StringBuilder wrappedText = new StringBuilder();
        int start = boundary.first();
        for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {
            wrappedText.append(text.substring(start, end));
            if (wrappedText.length() - wrappedText.lastIndexOf("\n") > width) {
                wrappedText.insert(wrappedText.lastIndexOf(" ") + 1, "\n");
            }
        }

        return wrappedText.toString();
    }
}