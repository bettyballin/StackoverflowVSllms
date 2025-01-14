import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import java.awt.*;

public class CustomHTMLEditor extends JEditorPane {

    public CustomHTMLEditor() {
        setEditable(false);
        setContentType("text/html");

        // Set a custom HTMLEditorKit
        CustomHTMLEditorKit editorKit = new CustomHTMLEditorKit();
        setEditorKit(editorKit);

        // Register custom tag
        HTML.Tag myTag = CustomHTMLEditorKit.MY_TAG;
        StyleSheet styleSheet = editorKit.getStyleSheet();
        AttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attrs, StyleConstants.ALIGN_CENTER);
        styleSheet.addStyle(myTag.toString(), attrs);
    }

    public static class CustomHTMLEditorKit extends HTMLEditorKit {

        public static final HTML.Tag MY_TAG = new HTML.UnknownTag("mytag");

        private static final HTMLFactory htmlFactory = new HTMLFactory() {
            @Override
            public View create(Element elem) {
                Object o = elem.getAttributes().getAttribute(StyleConstants.NameAttribute);
                if (o instanceof HTML.Tag) {
                    HTML.Tag kind = (HTML.Tag) o;
                    if (kind.equals(MY_TAG)) {
                        return new CustomView(elem);
                    }
                }
                return super.create(elem);
            }
        };

        @Override
        public ViewFactory getViewFactory() {
            return htmlFactory;
        }

        @Override
        public HTMLEditorKit.Parser getParser() {
            return super.getParser();
        }

        public static class CustomView extends InlineView {
            public CustomView(Element elem) {
                super(elem);
            }

            @Override
            public void paint(Graphics g, Shape allocation) {
                // Custom painting logic if necessary
                super.paint(g, allocation);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom HTML Editor");
        CustomHTMLEditor editorPane = new CustomHTMLEditor();

        String htmlString = "<html><body>some text <mytag id=\"1\">placeholder</mytag> some more text</body></html>";
        editorPane.setText(htmlString);

        frame.add(editorPane);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}