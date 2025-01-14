// Ensure JxBrowser library is included in your project.
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

public class EmbedActiveXInJava {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Browser browser = new Browser();
            BrowserView view = new BrowserView(browser);

            JFrame frame = new JFrame("Embed ActiveX Example");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(700, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            browser.loadURL("http://yourserver.com/yourpage.html"); // Serve the HTML which includes your plugins
        });
    }
}