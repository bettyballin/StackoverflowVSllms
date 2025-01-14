import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.undo.*;
import java.awt.*;

public class TextComponentUndoExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Removed Text Example");
        JTextArea textArea = new JTextArea(20, 50);
        UndoManager undoManager = new UndoManager();

        // Add an UndoableEditListener to the Document
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });

        // Add a DocumentFilter to capture the removed text
        ((AbstractDocument) textArea.getDocument()).setDocumentFilter(new DocumentFilter() {
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                // Capture the text being removed
                String removedText = fb.getDocument().getText(offset, length);
                // Proceed with the remove
                super.remove(fb, offset, length);
                // Create an UndoableEdit that stores the removed text
                undoManager.addEdit(new RemovedTextEdit(offset, removedText));
            }
        });

        JButton removeButton = new JButton("Remove Last Change");
        removeButton.addActionListener(e -> {
            try {
                if (undoManager.canUndo()) {
                    UndoableEdit edit = undoManager.editToBeUndone();
                    if (edit instanceof RemovedTextEdit) {
                        String removedText = ((RemovedTextEdit) edit).getRemovedText();
                        System.out.println("Removed Text: " + removedText);
                    }
                    undoManager.undo();
                }
            } catch (CannotUndoException ex) {
                JOptionPane.showMessageDialog(null, "Unable to undo: " + ex);
            }
        });

        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(removeButton, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    static class RemovedTextEdit extends AbstractUndoableEdit {
        private int offset;
        private String removedText;

        public RemovedTextEdit(int offset, String removedText) {
            this.offset = offset;
            this.removedText = removedText;
        }

        public String getRemovedText() {
            return removedText;
        }

        @Override
        public void undo() throws CannotUndoException {
            super.undo();
            // Undo logic can be implemented here if needed
        }

        @Override
        public void redo() throws CannotRedoException {
            super.redo();
            // Redo logic can be implemented here if needed
        }
    }
}