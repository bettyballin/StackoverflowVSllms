import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JustifiedTextDrawer {

    public static void drawJustifiedString(Graphics2D g, String text, int x, int y, int width) {
        Font font = g.getFont();
        AffineTransform transform = new AffineTransform();
        FontRenderContext frc = g.getFontRenderContext();
        
        String[] words = text.split(" ");
        List<String> lines = new ArrayList<>();
        StringBuilder lineBuilder = new StringBuilder();

        for (String word : words) {
            // Estimate the width of the line if we add this word
            String tempLine = lineBuilder.length() == 0 ? word : lineBuilder + " " + word;
            double wordWidth = font.getStringBounds(tempLine, frc).getWidth();
            
            if (wordWidth > width && lineBuilder.length() != 0) {
                lines.add(lineBuilder.toString());
                lineBuilder = new StringBuilder(word);
            } else {
                // Add the word to the current line
                if (lineBuilder.length() == 0)
                    lineBuilder.append(word);
                else
                    lineBuilder.append(" ").append(word);
            }
        }
        
        // Add the last line
        lines.add(lineBuilder.toString());

        for (String line : lines) {
            double stringWidth = font.getStringBounds(line, frc).getWidth();
            if (stringWidth < width && line.contains(" ")) {
                int numberOfSpaces = (int) line.chars().filter(ch -> ch == ' ').count();

                // Calculate additional space per gap
                float spacePerGap = (float)(width - stringWidth) / numberOfSpaces;

                lineBuilder = new StringBuilder();
                for (String word : line.split(" ")) {
                    if (lineBuilder.length() != 0)
                        x += g.getFontMetrics().stringWidth(lineBuilder.toString()) + spacePerGap;
                    
                    g.drawString(word, x, y);
                    lineBuilder.append(word).append(' ');
                }
            } else {
                // Draw the line without justification
                g.drawString(line, x, y);
            }

            y += g.getFontMetrics().getHeight();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Justified Text Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                String text = "This is a sample text that needs to be justified and wrapped using Java 2D\'s API.";
                drawJustifiedString(g2d, text, 20, 20, getWidth() - 40);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }
}