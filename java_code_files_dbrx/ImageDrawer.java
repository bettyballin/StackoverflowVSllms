import java.awt.*;
import java.awt.image.*;

public class ImageDrawer {
    public static void main(String[] args) {
        BufferedImage bufferedImage = new BufferedImage(300, 50, BufferedImage.TYPE_INT_RGB); // create a blank image of size 300x50 in RGB format
        Graphics2D grafix = (Graphics2D) bufferedImage.getGraphics(); // get the graphics context to draw on it
        grafix.setColor(Color.WHITE); // set the color for drawing
        grafix.fillRect(0, 0, 300, 50); // fill a rectangle with this color (white)
        Font f = new Font("Times New Roman", Font.BOLD, 24); // create new font for the text to be drawn on image
        grafix.setFont(f); // set above created font as default font in our graphics2D object
        grafix.drawString("My Text Image!", 10, 35); // draw a string with position (x=10, y=35)
        grafix.dispose();
    }
}