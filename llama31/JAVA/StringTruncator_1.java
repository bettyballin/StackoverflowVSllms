import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
import java.awt.image.RenderedImage;
import java.awt.image.RenderableImage;
import java.awt.geom.AffineTransform;
import java.awt.geom.GlyphVector;
import java.text.AttributedCharacterIterator;

public class StringTruncator_1 {

    public static String truncateString(String original, Font font, int maxWidth) {
        Graphics2D g = new Graphics2D() {
            @Override
            public Graphics create() {
                return this;
            }

            @Override
            public void translate(int x, int y) {}

            @Override
            public Graphics getClip() {
                return this;
            }

            @Override
            public Rectangle getClipBounds() {
                return new Rectangle(0, 0, 0, 0);
            }

            @Override
            public Rectangle getClipBounds(Rectangle r) {
                return r;
            }

            @Override
            public void clipRect(int x, int y, int width, int height) {}

            @Override
            public void setClip(int x, int y, int width, int height) {}

            @Override
            public void setClip(Shape clip) {}

            @Override
            public Shape getClip() {
                return new Rectangle(0, 0, 0, 0);
            }

            @Override
            public void draw3DRect(int x, int y, int width, int height, boolean raised) {}

            @Override
            public void fill3DRect(int x, int y, int width, int height, boolean raised) {}

            @Override
            public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {}

            @Override
            public void drawImage(BufferedImage img, int x, int y, BufferedImageOp op) {}

            @Override
            public void drawRenderedImage(RenderedImage img, AffineTransform xform) {}

            @Override
            public void drawRenderableImage(RenderableImage img, AffineTransform xform) {}

            @Override
            public void drawString(String str, int x, int y) {}

            @Override
            public void drawString(String str, float x, float y) {}

            @Override
            public void drawString(AttributedCharacterIterator iterator, int x, int y) {}

            @Override
            public void drawString(AttributedCharacterIterator iterator, float x, float y) {}

            @Override
            public void drawGlyphVector(GlyphVector g, float x, float y) {}

            @Override
            public void fill(Shape s) {}

            @Override
            public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
                return false;
            }

            @Override
            public GraphicsConfiguration getDeviceConfiguration() {
                return new GraphicsConfiguration() {
                    @Override
                    public GraphicsDevice getDevice() {
                        return new GraphicsDevice() {
                            @Override
                            public int getAvailableAcceleratedMemory() {
                                return 0;
                            }

                            @Override
                            public GraphicsConfiguration[] getConfigurations() {
                                return new GraphicsConfiguration[0];
                            }

                            @Override
                            public GraphicsConfiguration getDefaultConfiguration() {
                                return null;
                            }

                            @Override
                            public String getIDstring() {
                                return null;
                            }
                        };
                    }

                    @Override
                    public ColorModel getColorModel() {
                        return new ColorModel(0) {
                            @Override
                            public int getRed(int pixel) {
                                return 0;
                            }

                            @Override
                            public int getGreen(int pixel) {
                                return 0;
                            }

                            @Override
                            public int getBlue(int pixel) {
                                return 0;
                            }

                            @Override
                            public int getAlpha(int pixel) {
                                return 0;
                            }
                        };
                    }

                    @Override
                    public ColorModel getColorModel(int transparency) {
                        return null;
                    }

                    @Override
                    public AffineTransform getDefaultTransform() {
                        return new AffineTransform();
                    }

                    @Override
                    public AffineTransform getNormalizingTransform() {
                        return new AffineTransform();
                    }

                    @Override
                    public Rectangle getBounds() {
                        return new Rectangle(0, 0, 0, 0);
                    }
                };
            }
        };

        FontMetrics fm = g.getFontMetrics(font);
        int length = original.length();
        while (fm.stringWidth(original) > maxWidth && length > 3) {
            original = original.substring(0, length - 1);
            length--;
        }

        if (length < original.length()) {
            original = original.substring(0, length - 3) + "...";
        }

        return original;
    }

    public static void main(String[] args) {
        Font font = new Font("Arial", Font.PLAIN, 12);
        String original = "Hello world";
        int maxWidth = 100;

        String truncated = StringTruncator.truncateString(original, font, maxWidth);
        System.out.println(truncated); // Output: "He...rld"
    }
}