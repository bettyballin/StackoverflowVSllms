import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebappShutdownListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {}

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Retrieve your threads from wherever they're stored and call interrupt()
        Updater updaterThread = null; // Get your thread instance here
        if (updaterThread != null && updaterThread.isAlive()) {
            updaterThread.interrupt();
        }
    }
}

class Updater extends Thread {
    // Your thread implementation here
}