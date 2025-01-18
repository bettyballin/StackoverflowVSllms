import java.lang.String;
import javax.swing.text.*;

public class CustomDocumentExample {
    class CustomDocument extends PlainDocument {
        public void remove(int offset, int length) throws BadLocationException {
            String removedText = getText(offset, length); // Get the deleted snippet before it's actually deleted.
            super.remove(offset, length);                 // Delete as usual.
            System.out.println("Removed text: " + removedText); // Do something with your removed content here.
        }
    }
    public static void main(String[] args) {
    }
}