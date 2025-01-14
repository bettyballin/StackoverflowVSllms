import org.jfree.graphics2d.svg.SVGGraphics2D;
import java.awt.Graphics2D;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SVGExample {
    public static void main(String[] args) throws IOException {
        // Create an instance of the SVG generator
        SVGGraphics2D g2 = new SVGGraphics2D(500, 300);

        // Do some custom painting (draw a rectangle)
        Graphics2D graphics = g2.getGraphics2D();
        graphics.fillRect(10, 10, 480, 280);

        // Write the SVG to a file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.svg"))) {
            bw.write(g2.getSVGElement());
        }
    }
}