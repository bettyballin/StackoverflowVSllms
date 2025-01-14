import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class FlickeringSquares extends Canvas implements Runnable {

    private final int width = 800;
    private final int height = 600;
    private final int squareSize = 50;
    private boolean isColorA = true;
    private BufferStrategy bs;

    public FlickeringSquares() {
        setSize(width, height);
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        // Removed setDefaultCloseOperation from Canvas

        JFrame frame = new JFrame("Flickering Squares");
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        createBufferStrategy(2); // Double buffering
    }

    private void render() {
        if (bs == null) {
            bs = getBufferStrategy();
            if (bs == null) {
                return; // Buffer strategy not yet created
            }
        }
        Graphics g = null;

        try {
            g = bs.getDrawGraphics();
            g.setColor(isColorA ? Color.WHITE : Color.BLACK);

            int columns = (int) Math.ceil(width / (double) squareSize);
            int rows = (int) Math.ceil(height / (double) squareSize);

            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    g.fillRect(i * squareSize, j * squareSize, squareSize, squareSize);
                }
            }
        } finally {
            if (g != null) {
                g.dispose();
            }
        }

        bs.show();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1_000_000_000D / 85; // 85 Hz

        int frames = 0;
        int ticks = 0;

        long lastTimer = System.currentTimeMillis();

        while (true) {
            long now = System.nanoTime();
            boolean shouldRender = false;

            while (now - lastTime >= nsPerTick) {
                lastTime += nsPerTick;
                ++ticks;
                isColorA = !isColorA; // Toggle color
                shouldRender = true;
            }

            if (shouldRender) {
                render();
                frames++;
            }

            // Optional sleep to reduce CPU usage and heat generation
            // Thread.sleep(1); // Uncomment if necessary

            if (System.currentTimeMillis() - lastTimer >= 1000) {
                lastTimer += 1000;
                System.out.println("FPS: " + frames + ", TPS: " + ticks);
                frames = 0;
                ticks = 0;
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new FlickeringSquares()).start();
    }
}