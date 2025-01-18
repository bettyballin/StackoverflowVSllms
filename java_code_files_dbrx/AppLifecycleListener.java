import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import org.apache.log4j.LogManager;
import org.apache.log4j.spi.RepositorySelector;
import org.apache.log4j.spi.LoggerRepository;

public class AppLifecycleListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        // Set a custom RepositorySelector implementation for this web app
        LogManager.setRepositorySelector(new RepositorySelector() {
            @Override
            public LoggerRepository getLoggerRepository() {
                // Implement your custom LoggerRepository retrieval logic here
                return LogManager.getLoggerRepository();
            }
        }, Log4jWEBLogFactory.class);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // Cleanup resources if necessary
    }
}

class Log4jWEBLogFactory {
    // Empty class to ensure the code compiles
}