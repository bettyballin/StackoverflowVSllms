import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // Writing properties (to file)
        Properties prop = new Properties();
        prop.setProperty("clickArea1", "5"); // number of clicks as string value
        prop.setProperty("clickArea2", "3");

        try (FileOutputStream out = new FileOutputStream("config.properties")) {
            prop.store(out, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading properties
        prop = new Properties();

        try (InputStream in = new FileInputStream("config.properties")) {
            prop.load(in);

            int numClicks1 = Integer.parseInt(prop.getProperty("clickArea1")); // convert property value back to integer if needed
            int numClicks2 = Integer.parseInt(prop.getProperty("clickArea2"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}