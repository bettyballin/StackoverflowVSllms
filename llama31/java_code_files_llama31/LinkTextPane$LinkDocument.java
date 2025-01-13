/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

private class LinkTextPane.LinkDocument
extends DefaultStyledDocument {
    private LinkTextPane.LinkDocument() {
    }

    @Override
    public void insertString(int n, String string, AttributeSet attributeSet) throws BadLocationException {
        super.insertString(n, string, attributeSet);
        this.highlightLinks();
    }

    @Override
    public void remove(int n, int n2) throws BadLocationException {
        super.remove(n, n2);
        this.highlightLinks();
    }

    private void highlightLinks() {
        try {
            String string = this.getText(0, this.getLength());
            Matcher matcher = Pattern.compile(LinkTextPane.LINK_PATTERN).matcher(string);
            while (matcher.find()) {
                int n = matcher.start();
                int n2 = matcher.end();
                this.setCharacterAttributes(n, n2 - n, this.getLinkStyle(), true);
            }
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
    }

    private Style getLinkStyle() {
        StyleContext styleContext = new StyleContext();
        Style style = styleContext.getStyle("default");
        Style style2 = styleContext.addStyle("link", style);
        style2.addAttribute(StyleConstants.Foreground, Color.BLUE);
        style2.addAttribute(StyleConstants.Underline, Boolean.TRUE);
        return style2;
    }
}
