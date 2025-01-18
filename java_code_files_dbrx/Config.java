import java.lang.String;
import java.io.*;
import java.util.*;
public class Config {
  private Properties prop = new Properties();
  public void config() {
    String configFile= "config.properties";
    try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
      prop.load(reader);
        /* Get properties */
      System.out.println("UserName: " + prop.getProperty("username"));
      System.out.println("Password: " + prop.getProperty("password"));

    } catch (Exception e) {}  }
	public static void main(String[] args) {
	}
}