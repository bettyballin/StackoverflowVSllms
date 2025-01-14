import java.util.*;
import java.util.concurrent.TimeUnit;

public class Updater_2 {
    class Updater extends Thread {
        private volatile boolean running = true; // Better variable name for readability

        @Override
        public void run() {
            Integer lastUpdateLogId = CommonBeanFactory.getXXX()
                                  .getLastUpdateLogRecordKey(MLConstants.SMART_DB_NAME);

            List<UpdateLog> updateLogRecords;
            while (running) { // Use the running flag
                boolean isConfigurationUpdateRequested = false;

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore interrupted status
                    running = false; // Set flag to false so loop exits cleanly
                    break;
                }

                updateLogRecords = CommonBeanFactory.getXXX()
                                   .getLastFactsUpdateLogRecords(MLConstants.XXXX, lastUpdateLogId);

                for (UpdateLog updateLog : updateLogRecords) {
                    if (updateLog.getTable_name().equals(MLConstants.CONFIG_RELOAD)) {
                        isConfigurationUpdateRequested = true;
                    }

                    lastUpdateLogId = updateLog.getObjectKey();
                }

                if (isConfigurationUpdateRequested) {
                    Configuration.getInstance().loadConfiguration();
                }
            }
        }

        // No need for getter and setter for running, use interrupt()
    }

    public static void main(String[] args) {
        // Start the Updater thread
        Updater_2 updater2Instance = new Updater_2();
        Updater updater = updater2Instance.new Updater();
        updater.start();
    }
}

// Additional classes to make the code compile
class UpdateLog {
    public String getTable_name() {
        return ""; // Return empty string
    }

    public Integer getObjectKey() {
        return 0;
    }
}

class MLConstants {
    public static final String SMART_DB_NAME = "SMART_DB_NAME";
    public static final String XXXX = "XXXX";
    public static final String CONFIG_RELOAD = "CONFIG_RELOAD";
}

class Configuration {
    private static Configuration instance = new Configuration();

    public static Configuration getInstance() {
        return instance;
    }

    public void loadConfiguration() {
        // Do nothing
    }
}

class CommonBeanFactory {
    public static CommonBean getXXX() {
        return new CommonBean();
    }
}

class CommonBean {
    public Integer getLastUpdateLogRecordKey(String dbName) {
        return 0;
    }

    public List<UpdateLog> getLastFactsUpdateLogRecords(String xxxx, Integer lastUpdateLogId) {
        return new ArrayList<>();
    }
}