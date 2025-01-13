/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JEditorPane;

public class LogViewer {
    public static void main(String[] stringArray) {
        JEditorPane jEditorPane = new JEditorPane();
        LogDocument logDocument = new LogDocument();
        jEditorPane.setDocument(logDocument);
        logDocument.appendLogEntry(new LogEntry("Hello, world!", LogEntry.Level.INFO));
        logDocument.appendLogEntry(new LogEntry("Error occurred!", LogEntry.Level.ERROR));
    }
}
