import java.lang.String;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;

public class JustifiedText {
    public static void drawString(Graphics2D g2d, String text, float x, float y, float width) {
        Font font = g2d.getFont();
        FontRenderContext frc = g2d.getFontRenderContext();
        TextLayout layout = new TextLayout(text, font, frc);
        
        // Calculate the justification ratio
        float justificationRatio = (width - layout.getVisibleAdvance()) / layout.getAdvance();
        
        // Create a new TextLayout with justification
        TextLayout justifiedLayout = layout.getJustifiedLayout(justificationRatio);
        
        // Draw the justified text
        justifiedLayout.draw(g2d, x, y);
    }

	public static void main(String[] args) {
	}
}