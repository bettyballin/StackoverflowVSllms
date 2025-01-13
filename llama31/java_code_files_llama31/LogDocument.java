/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.text.DefaultStyledDocument;

class LogDocument
extends DefaultStyledDocument {
    LogDocument() {
    }

    public void appendLogEntry(LogEntry logEntry) {
        try {
            this.insertString(this.getLength(), logEntry.getMessage() + "\n", null);
        }
        catch (Exception exception) {
            System.err.println("Error appending log entry: " + exception.getMessage());
        }
    }
}
