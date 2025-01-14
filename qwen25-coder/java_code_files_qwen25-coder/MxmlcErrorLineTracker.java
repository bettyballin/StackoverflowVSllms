import java.lang.String;
import java.lang.Integer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.eclipse.ui.console.PatternMatchEvent;
import org.eclipse.ui.console.AbstractPatternMatchListener;
import org.eclipse.ui.console.TextConsole;
import org.eclipse.ui.console.MessageConsoleHyperlink;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.AbstractTextEditor;

public class MxmlcErrorLineTracker extends AbstractPatternMatchListener {

    public MxmlcErrorLineTracker() {
        // Define a regex pattern that matches your error format
        String patternString = "(.*)\\((\\d+)\\): col: (\\d+) Warning: (.*)";
        setRegex(patternString);
        setCompilerFlags(Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
    }

    @Override
    protected void matchFound(PatternMatchEvent event) {
        TextConsole console = getConsole();
        IDocument doc = console.getDocument();

        try {
            // Extract the file path, line number, column number and message from the matched groups
            String fullLine = doc.get(event.getOffset(), event.getLength());
            Pattern pattern = Pattern.compile(getRegex(), getCompilerFlags());
            Matcher matcher = pattern.matcher(fullLine);
            if (matcher.find()) {
                String filePath = matcher.group(1);
                int lineNumber = Integer.parseInt(matcher.group(2));
                // Optionally handle column number, though often not used for jumping to line in some IDEs
                int colNumber = Integer.parseInt(matcher.group(3));

                // Create a hyperlink or other action based on the error details
                // This is a simplified example and you'll need to create proper actions
                console.addHyperlink(new OpenFileHyperlink(filePath, lineNumber, colNumber), event.getOffset(), event.getLength());
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private static class OpenFileHyperlink extends MessageConsoleHyperlink {

        private final String filePath;
        private final int lineNumber;
        private final int columnNumber;

        public OpenFileHyperlink(String filePath, int lineNumber, int columnNumber) {
            this.filePath = filePath;
            this.lineNumber = lineNumber;
            this.columnNumber = columnNumber;
        }

        @Override
        public void linkActivated() {
            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            try {
                IEditorPart editor = IDE.openEditor(window.getActivePage(), Path.fromOSString(filePath), true);
                if (editor instanceof AbstractTextEditor) {
                    ((AbstractTextEditor) editor).selectAndReveal((lineNumber - 1) * 80, 0); // Simplified line selection
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void linkEntered() {}

        @Override
        public void linkExited() {}
    }

    public static void main(String[] args) {
    }
}