import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.AttributedString;
import java.text.AttributedCharacterIterator;
import java.text.BreakIterator;

public class Main {
    public static void main(String[] args) {
        // Create an instance of JustifiedText
        JustifiedText jt = new JustifiedText();

        // Get Graphics context from a BufferedImage
        BufferedImage bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        // Create a font object that you wish to use for drawing text
        Font myFont = new Font("Serif", Font.PLAIN, 24);

        // Create AttributedString with the desired font
        AttributedString as = new AttributedString("Sample Text Here");
        as.addAttribute(TextAttribute.FONT, myFont);

        // Define position and width
        float x = 50;
        float y = 50;
        float width = 400;

        // Draw the justified text
        jt.drawJustified(g2d, as, x, y, width);

        // Dispose the graphics context
        g2d.dispose();
    }
}

class JustifiedText {
    public void drawJustified(Graphics2D g2d, AttributedString as, float x, float y, float width) {
        // Get the FontRenderContext from Graphics2D
        FontRenderContext frc = g2d.getFontRenderContext();

        // Create a LineBreakMeasurer for the text
        AttributedCharacterIterator iterator = as.getIterator();
        LineBreakMeasurer measurer = new LineBreakMeasurer(iterator, BreakIterator.getLineInstance(), frc);
        int start = iterator.getBeginIndex();
        int end = iterator.getEndIndex();

        // Loop until all text is processed
        while (measurer.getPosition() < end) {
            // Measure the next layout
            TextLayout layout = measurer.nextLayout(width);

            // Move y-coordinate by the ascent of the layout
            y += layout.getAscent();

            // Check if the line should be justified
            if (measurer.getPosition() < end) {
                // Justify the layout
                layout = layout.getJustifiedLayout(width);
            }

            // Draw the text layout at the specified position
            layout.draw(g2d, x, y);

            // Move y-coordinate by the descent and leading of the layout
            y += layout.getDescent() + layout.getLeading();
        }
    }
}