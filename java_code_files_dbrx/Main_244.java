import java.util.concurrent.*;

public class Main_244 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        int refreshMillis = 16; // Refresh rate in ms for a frame limit of approximately 60 FPS (1 / 0.016 ~= 60)
        Game m = new Game();
        Runnable gameFrameTask = () -> {
            try {
                m.controls();
                m.update();
                m.repaint();
            } catch(Exception e) { /* do something with exceptions */ }
        };
        executor.scheduleAtFixedRate(gameFrameTask, 0, refreshMillis, TimeUnit.MILLISECONDS);
    }
}

class Game {
    public void controls() {
        // Implement controls logic here
    }

    public void update() {
        // Implement update logic here
    }

    public void repaint() {
        // Implement repaint logic here
    }
}