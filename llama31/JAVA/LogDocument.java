import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class LogDocument extends DefaultStyledDocument {
    private List<Object> logEntries = new ArrayList<>();

    public void appendLogEntry(Object entry) {
        logEntries.add(entry);
        insertLogEntry(entry);
    }

    private void insertLogEntry(Object entry) {
        // Create a new paragraph element
        Element paragraph = getParagraphElement(getLength());

        // Insert the entry as text
        try {
            insertString(getLength(), entry.toString(), null);
        } catch (BadLocationException e) {
            // Handle exception
        }

        // Apply styles if needed
        if (entry instanceof LogEntry) {
            LogEntry logEntry = (LogEntry) entry;
            if (logEntry.getLevel() == LogEntry.Level.ERROR) {
                // Apply error style
                SimpleAttributeSet errorStyle = new SimpleAttributeSet();
                StyleConstants.setForeground(errorStyle, Color.RED);
                setCharacterAttributes(paragraph.getStartOffset(), paragraph.getEndOffset() - paragraph.getStartOffset(), errorStyle, false);
            }
        }
    }

    public static void main(String[] args) {
        LogDocument logDocument = new LogDocument();
        logDocument.appendLogEntry(new LogEntry("Info message", LogEntry.Level.INFO));
        logDocument.appendLogEntry(new LogEntry("Error message", LogEntry.Level.ERROR));
    }
}

class LogEntry {
    private String message;
    private Level level;

    public LogEntry(String message, Level level) {
        this.message = message;
        this.level = level;
    }

    public String toString() {
        return message;
    }

    public Level getLevel() {
        return level;
    }

    public enum Level {
        INFO, WARNING, ERROR
    }
}