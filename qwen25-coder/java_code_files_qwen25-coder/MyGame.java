import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class MyGame extends GameCanvas implements Runnable {
    private Thread gameThread;
    private boolean running = true;

    public MyGame() {
        setFullScreenMode(true);
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        Graphics g = getGraphics();
        while (running) {
            // Perform game logic here, try to minimize object creation here

            synchronized (getLock()) {
                flushGraphics();
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
                // Render graphics
            }

            try {
                Thread.sleep(16); // Roughly 60 FPS
            } catch (InterruptedException ie) {}
        }
    }

    protected void keyPressed(int keyCode) {
        switch (getGameAction(keyCode)) {
            case KEY_NUM5:
                running = false;
                break;
        }
    }

    public static void main(String[] args) {
        new MyGame();
    }
}

// Define GameCanvas class with required methods
class GameCanvas extends Canvas {

    public void setFullScreenMode(boolean fullScreen) {
        // Implement as needed
    }

    public Object getLock() {
        return this; // Use 'this' object for synchronization
    }

    public int getGameAction(int keyCode) {
        // Map key codes to game actions as needed
        return keyCode;
    }

    public static final int KEY_NUM5 = KeyEvent.VK_NUMPAD5; // Define key constant

    public void flushGraphics() {
        // Implement as needed
        repaint();
    }
}