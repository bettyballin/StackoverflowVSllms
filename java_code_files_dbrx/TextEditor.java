import java.lang.String;
import java.util.*;
public class TextEditor {
    private String currentText = "";
    private Stack<String> undoStack;

    public TextEditor() {
        this.undoStack = new Stack<>();
    }

    // Replace <your-action> with actual actions like user input or typing in the editor
    public void actionPerformed(String text) {
	// Append new character to currentText or handle other changes here
        if (!this.currentText.equals("")) {
            this.undoStack.push(this.currentText); // Store previous current state before change
        }
	this.currentText += "<your-action>";  // Change: your actual logic should go here
    }

    public void undo() throws EmptyStackException {
        try {
            this.currentText = this.undoStack.pop();   // Retrieve and set previous saved state
        } catch (EmptyStackException e) {
            System.err.println("No more actions to undo.");
        }
    }

	public static void main(String[] args) {
	}
}