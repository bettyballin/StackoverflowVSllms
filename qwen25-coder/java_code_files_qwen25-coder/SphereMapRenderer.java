import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.stream.IntStream;

public class SphereMapRenderer extends JPanel {
    private BufferedImage texture; // Assume this is your cylindrical map texture

    public SphereMapRenderer(BufferedImage texture) {
        this.texture = texture;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cx = getWidth() / 2;
        int cy = getHeight() / 2;
        int radius = Math.min(cx, cy);

        drawSphere(g, cx, cy, radius);
    }

    private void drawSphere(Graphics g, int centerX, int centerY, int radius) {
        double thetaMax = Math.PI * 1.5; // Example angle for rotation (adjust as needed)
        double phiMax = Math.PI;

        IntStream.range(0, texture.getHeight()).forEach(y -> {
            double phi = map(y, 0, texture.getHeight(), 0, phiMax);
            int maxX = (int)(Math.sin(phi) * texture.getWidth());

            for (int x = -maxX / 2 + centerX; x < maxX / 2 + centerX; x++) {
                double theta = map(x, centerX - maxX / 2, centerX + maxX / 2, 0, thetaMax);

                double cosPhi = Math.cos(phi);
                int px = (int) (centerX + radius * Math.sin(theta) * cosPhi);
                int py = (int) (centerY - radius * Math.sin(phi));
                if (px >= 0 && py >= 0 && px < getWidth() && py < getHeight()) {
                    int texX = (int) ((theta / (2 * Math.PI)) * texture.getWidth());
                    texX = (texX + texture.getWidth()) % texture.getWidth(); // Ensure texX is in bounds
                    g.setColor(new Color(texture.getRGB(texX, y)));
                    g.drawLine(px, py, px, py);
                }
            }
        });
    }

    private double map(double value, double fromLow, double fromHigh, double toLow, double toHigh) {
        return (value - fromLow) * (toHigh - toLow) / (fromHigh - fromLow) + toLow;
    }

    public static void main(String[] args) {
        BufferedImage texture = new BufferedImage(1024, 512, BufferedImage.TYPE_INT_RGB);
        // Load or generate your cylindrical map as needed

        JFrame frame = new JFrame("Sphere Map");
        SphereMapRenderer renderer = new SphereMapRenderer(texture);
        renderer.setPreferredSize(new Dimension(800, 600));
        frame.add(renderer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}