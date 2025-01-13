import java.text.AttributedString;
import java.text.BreakIterator;
import java.text.CharacterIterator;
import java.text.LineBreakMeasurer;

public class CustomLineBreakMeasurer {
    public static void main(String[] args) {
        String text = "Hello\nWorld, this is a test.";
        AttributedString attributedString = new AttributedString(text);
        LineBreakMeasurer measurer = new LineBreakMeasurer(attributedString.getIterator(), new CustomBreakIterator(text));

        // Use the measurer to layout the text...
    }

    static class CustomBreakIterator extends BreakIterator {
        private String caretString;

        public CustomBreakIterator(String text) {
            this.caretString = text;
        }

        @Override
        public int next() {
            int nextBreak = super.next();
            if (nextBreak != DONE && nextBreak > 0 && Character.isWhitespace(caretString.charAt(nextBreak - 1))) {
                // If the next break is after a newline character, return the index of the newline character
                if (caretString.charAt(nextBreak - 1) == '\n') {
                    return nextBreak - 1;
                }
            }
            return nextBreak;
        }

        @Override
        public void setText(CharacterIterator newBreakIterator) {
            super.setText(newBreakIterator);
            caretString = newBreakIterator.toString();
        }
    }
}