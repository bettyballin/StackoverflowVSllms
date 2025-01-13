import javax.swing.JEditorPane;
import javax.swing.text.DefaultStyledDocument;

// Define the LogEntry class
class LogEntry {
    public enum Level {
        INFO,
        ERROR
    }

    private String message;
    private Level level;

    public LogEntry(String message, Level level) {
        this.message = message;
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public Level getLevel() {
        return level;
    }
}

// Define the LogDocument class
class LogDocument extends DefaultStyledDocument {
    public void appendLogEntry(LogEntry entry) {
        try {
            insertString(getLength(), entry.getMessage() + "\n", null);
        } catch (Exception e) {
            System.err.println("Error appending log entry: " + e.getMessage());
        }
    }
}

public class LogViewer {
    public static void main(String[] args) {
        JEditorPane editorPane = new JEditorPane();
        LogDocument document = new LogDocument();
        editorPane.setDocument(document);

        // Append log entries
        document.appendLogEntry(new LogEntry("Hello, world!", LogEntry.Level.INFO));
        document.appendLogEntry(new LogEntry("Error occurred!", LogEntry.Level.ERROR));
    }
}