import java.lang.String;
import java.util.Stack;

public class SimpleTextEditor {
    private StringBuilder text;
    private Stack<String> undoHistory;

    public SimpleTextEditor() {
        text = new StringBuilder();
        undoHistory = new Stack<>();
    }

    // Method to add text
    public void insert(String str) {
        // Save the current state before changing the text
        undoHistory.push(text.toString());
        text.append(str);
    }

    // Undo last action
    public void undo() {
        if (!undoHistory.isEmpty()) {
            // Restore the last saved state
            text.replace(0, text.length(), undoHistory.pop());
        }
    }

    // Get current text content
    @Override
    public String toString() {
        return text.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        SimpleTextEditor editor = new SimpleTextEditor();
        System.out.println("Initial Text: " + editor);

        editor.insert("Hello, ");
        System.out.println("After insert 'Hello, ': " + editor);
        
        editor.insert("World!");
        System.out.println("After insert 'World!': " + editor);
        
        editor.undo();
        System.out.println("After undo: " + editor);
    }
}