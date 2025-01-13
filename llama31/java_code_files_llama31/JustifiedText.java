/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

public class JustifiedText {
    public static void drawString(Graphics2D graphics2D, String string, float f, float f2, float f3) {
        Font font = graphics2D.getFont();
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        TextLayout textLayout = new TextLayout(string, font, fontRenderContext);
        float f4 = (f3 - textLayout.getVisibleAdvance()) / textLayout.getAdvance();
        TextLayout textLayout2 = textLayout.getJustifiedLayout(f4);
        textLayout2.draw(graphics2D, f, f2);
    }

    public static void main(String[] stringArray) {
    }
}
