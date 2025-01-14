import java.lang.String;
import java.awt.*;

public class MultiDisplayExample {
    public static void main(String[] args) throws InterruptedException {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();

        if (gs.length < 4) {
            throw new RuntimeException("Not enough displays connected.");
        }

        for (int i = 0; i < 4; i++) {
            final int index = i;
            GraphicsConfiguration gc = gs[index].getDefaultConfiguration();
            
            EventQueue.invokeLater(() -> {
                Frame frame = new Frame(gc);
                frame.setSize(800, 600);
                frame.addNotify(); // create the peer with specified GC
                frame.setVisible(true);

                // Add your rendering code here
                Graphics g = gc.createCompatibleImage(frame.getWidth(), frame.getHeight()).getGraphics();
                g.setColor(Color.RED); // just an example: draw a red background
                g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
                g.dispose();

                frame.validate(); // make sure we're ready to render
            });
        }
    }
}