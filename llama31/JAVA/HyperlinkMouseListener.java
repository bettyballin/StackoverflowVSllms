import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.text.JTextComponent;

public class HyperlinkMouseListener {
    public HyperlinkMouseListener(JTextComponent textComponent) {
        textComponent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pos = textComponent.viewToModel(e.getPoint());
                if (pos != -1) {
                    try {
                        int start = textComponent.getDocument().getText(0, pos).lastIndexOf('[');
                        int end = textComponent.getDocument().getText(pos, textComponent.getDocument().getLength() - pos).indexOf(']');
                        if (start != -1 && end != -1) {
                            String link = textComponent.getDocument().getText(start + 1, end - 1);
                            // Open the link in a browser
                            Desktop.getDesktop().browse(new URI(link));
                        }
                    } catch (Exception ex) {
                        // Handle exception
                        System.out.println("An error occurred: " + ex.getMessage());
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        // Create a new JTextComponent to test the HyperlinkMouseListener
        JTextComponent textComponent = new javax.swing.JTextArea();
        textComponent.setText("This is a [http://www.example.com] link.");
        new HyperlinkMouseListener(textComponent);
    }
}