import java.lang.String;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

public class LinkTextPane extends JTextPane {
    private static final String LINK_PATTERN = "\\[(.*?)\\]";

    public LinkTextPane() {
        super();
        setDocument(new LinkDocument());
    }

    private class LinkDocument extends DefaultStyledDocument {
        @Override
        public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
            super.insertString(offset, str, a);
            highlightLinks();
        }

        @Override
        public void remove(int offs, int len) throws BadLocationException {
            super.remove(offs, len);
            highlightLinks();
        }

        private void highlightLinks() {
            try {
                String text = getText(0, getLength());
                Matcher matcher = Pattern.compile(LINK_PATTERN).matcher(text);
                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    setCharacterAttributes(start, end - start, getLinkStyle(), true);
                }
            } catch (BadLocationException e) {
                // Handle exception
            }
        }

        private Style getLinkStyle() {
            StyleContext context = new StyleContext();
            Style scheme = context.getStyle(StyleContext.DEFAULT_STYLE);
            Style linkStyle = context.addStyle("link", scheme);
            linkStyle.addAttribute(StyleConstants.Foreground, Color.BLUE);
            linkStyle.addAttribute(StyleConstants.Underline, Boolean.TRUE);
            return linkStyle;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        LinkTextPane textPane = new LinkTextPane();
        frame.add(textPane);
        frame.setVisible(true);

        textPane.setText("This is a [link] to a website.");
    }
}