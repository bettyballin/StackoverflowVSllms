import java.util.Stack;

public class TextEditor {
    private Stack<String> undoStack = new Stack<>();
    private String currentText = "";

    public void insertText(String text) {
        undoStack.push(getCurrentText());
        currentText += text;
        System.out.println("Text inserted: " + text);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            String previousText = undoStack.pop();
            currentText = previousText;
            System.out.println("Undo: " + currentText);
        }
    }

    private String getCurrentText() {
        return currentText;
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.insertText("Hello, ");
        textEditor.insertText("World!");
        textEditor.undo();
        textEditor.undo();
    }
}