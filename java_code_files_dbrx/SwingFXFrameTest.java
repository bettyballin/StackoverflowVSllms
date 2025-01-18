import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.*;

public class SwingFXFrameTest {
    private static void initAndDisplayComponent() {
        Platform.setImplicitExit(true);

        JFrame frame = new JFrame("JavaFX in Swing");
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.pack(); // Pack the components inside container (JFrame)
        frame.setVisible(true);

        Platform.runLater(() -> {
            WebView view = new WebView();
            WebEngine engine = view.getEngine();
            engine.loadContent("<h1>HTML content sample</h1>" +
                "<p>This is an HTML content parsed and displayed within Swing application.");

            Scene scene = new Scene(view);
            fxPanel.setScene(scene); // Set JavaFX WebView as a component of JFrame/Swing window.
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> initAndDisplayComponent());
    }
}