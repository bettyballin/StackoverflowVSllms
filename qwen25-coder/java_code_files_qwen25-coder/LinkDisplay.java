import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.text.*;
import java.util.regex.*;

public class LinkDisplay {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Link Display Example");
        final JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        String content = "This is a sample text with a link [http://example.com] and another one [https://another-example.com].";
        displayTextWithLinks(textPane, content);

        frame.add(new JScrollPane(textPane));
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void displayTextWithLinks(final JTextPane textPane, String content) {
        final Pattern linkPattern = Pattern.compile("\\[(http[s]?://[^\\]]+)\\]");
        Matcher matcher = linkPattern.matcher(content);

        int lastFoundEnd = 0;
        final StyledDocument doc = textPane.getStyledDocument();

        while (matcher.find()) {
            try {
                // Add the normal text before the URL
                String beforeLink = content.substring(lastFoundEnd, matcher.start());
                doc.insertString(doc.getLength(), beforeLink, null);

                // Create a clickable styled document with the URL
                SimpleAttributeSet linkStyle = new SimpleAttributeSet();
                StyleConstants.setForeground(linkStyle, java.awt.Color.BLUE);
                StyleConstants.setUnderline(linkStyle, true);
                String urlText = matcher.group(1);
                linkStyle.addAttribute("URL", urlText);
                doc.insertString(doc.getLength(), "[" + urlText + "]", linkStyle);

                lastFoundEnd = matcher.end();
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }

        // Insert remaining text
        try {
            String trailingText = content.substring(lastFoundEnd);
            doc.insertString(doc.getLength(), trailingText, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        // Add MouseListener to the textPane
        textPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickPos = textPane.viewToModel(e.getPoint());
                if (clickPos >= 0) {
                    try {
                        Element elementAtCursor = doc.getCharacterElement(clickPos);
                        AttributeSet attributes = elementAtCursor.getAttributes();
                        if (StyleConstants.isUnderlined(attributes)) {
                            // Open URL here...
                            String url = (String) attributes.getAttribute("URL");
                            if (url != null) {
                                System.out.println("Opening: " + url);
                                java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}