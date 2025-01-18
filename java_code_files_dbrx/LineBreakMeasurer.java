import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.text.AttributedString;
import java.text.BreakIterator;
public class LineBreakMeasurer{
    public static void main(String[] args) {
        // Your text that might contain new line character(\n),
        String yourText = "Hello\n This is new line!";
        BreakIterator breakIterator = BreakIterator.getLineInstance();
        int width = 200;
        int height = 100;
        int imageType = BufferedImage.TYPE_INT_ARGB;
        Graphics2D g2d = (Graphics2D) new BufferedImage(width, height, imageType).createGraphics();
        FontRenderContext frc = g2d.getFontRenderContext();
        AttributedString attrStr = new AttributedString(yourText); // Adding attributes to your string if you want to customize e.g. font colors etc. Otherwise this remains same, i.e., no need for it and just use directly `yourText`.
        g2d.drawString(attrStr.getIterator(), 0, 0); // Here replace (0,0) with your own co-ordinates as per the requirement. It can be any coordinates where you wish to draw string on panel or JComponent etc.
    }
}