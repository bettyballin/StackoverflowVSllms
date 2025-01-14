import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.text.BreakIterator;

public class MultiLineTextDrawer {
    public static void drawString(Graphics2D g, String text, int x, int y) {
        Font font = g.getFont();
        FontRenderContext frc = g.getFontRenderContext();
        FontMetrics fontMetrics = g.getFontMetrics(font);
        AttributedString attributedString = new AttributedString(text);
        attributedString.addAttribute(TextAttribute.FONT, font);

        // Split the text at newline characters
        String[] lines = text.split("\n");
        int currentY = y;

        for (String line : lines) {
            AttributedString as = new AttributedString(line);
            as.addAttribute(TextAttribute.FONT, font);

            LineBreakMeasurer measurer = new LineBreakMeasurer(as.getIterator(), frc);

            int width = (int) fontMetrics.getStringBounds(line, g).getWidth();
            TextLayout layout = measurer.nextLayout(width);

            if (layout != null) {
                int ascent = fontMetrics.getAscent();
                int descent = fontMetrics.getDescent();
                int leading = fontMetrics.getLeading();

                float dx = x;
                float dy = currentY + ascent;

                layout.draw(g, dx, dy);
                currentY += ascent + descent + leading;
            }
        }
    }

    public static void main(String[] args) {
    }
}