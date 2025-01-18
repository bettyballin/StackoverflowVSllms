import java.lang.String;
import java.io.*;
import java.net.*;
public class NetworkTest {
  public static void main(String[] args) throws Exception {
    URL url = new URL("https://example.com"); // replace it with a larger file for accurate measurement
    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

    long startTime = System.nanoTime();
    InputStream in = httpConn.getInputStream();
    int size = in.available();
    while ((in.read()) != -1);
    long endTime   = System.nanoTime();
    double duration = (endTime - startTime) / 1000000000.0; // Divide by 1 billion to get seconds.

    int byteSizeMb = size/1024/1024;
    Double speed =  ((double)byteSizeMb / duration);
    System.out.println("Speed is: "+String.format("%f",speed)+" MB/s");
   }
}