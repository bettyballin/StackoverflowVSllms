import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class CodeToHtml {
    public static void main(String[] args) {
        // Create a display
        Display display = new Display();

        // Create a GC to render the code
        GC gc = new GC(display);

        // Set the code to render
        String code = "def hello_world\n  puts 'Hello, World!'\nend";

        // Set the syntax highlighting colors
        RGB keywordColor = new RGB(0, 0, 255);
        RGB stringColor = new RGB(255, 0, 0);

        // Render the code to HTML
        String html = renderCodeToHtml(gc, code, keywordColor, stringColor);

        // Print the HTML
        System.out.println(html);

        // Dispose the GC and display
        gc.dispose();
        display.dispose();
    }

    private static String renderCodeToHtml(GC gc, String code, RGB keywordColor, RGB stringColor) {
        // Implement your syntax highlighting logic here
        // For simplicity, this example just renders the code as-is
        return "<pre><code>" + code + "</code></pre>";
    }
}