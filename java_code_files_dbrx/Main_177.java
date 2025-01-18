import java.lang.String;
import java.io.*;

public class Main_177 {
  public static void main(String[] args) throws Exception {
    ProcessBuilder pb = new ProcessBuilder("regsvr32", "/s", "your_activex_dll.dll"); // replace with your dll path
    pb.redirectErrorStream(true);
    Process process = pb.start();

    InputStream is = process.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    String line;
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
    }
  }
}