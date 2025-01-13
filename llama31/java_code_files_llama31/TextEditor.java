/*
 * Decompiled with CFR 0.152.
 */
import java.util.Stack;

public class TextEditor {
    private Stack<String> undoStack = new Stack();
    private String currentText = "";

    public void insertText(String string) {
        this.undoStack.push(this.getCurrentText());
        this.currentText = this.currentText + string;
        System.out.println("Text inserted: " + string);
    }

    public void undo() {
        if (!this.undoStack.isEmpty()) {
            String string;
            this.currentText = string = this.undoStack.pop();
            System.out.println("Undo: " + this.currentText);
        }
    }

    private String getCurrentText() {
        return this.currentText;
    }

    public static void main(String[] stringArray) {
        TextEditor textEditor = new TextEditor();
        textEditor.insertText("Hello, ");
        textEditor.insertText("World!");
        textEditor.undo();
        textEditor.undo();
    }
}
