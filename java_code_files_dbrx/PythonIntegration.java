import java.lang.String;
import java.io.*;

public class PythonIntegration {
  public static void main(String[] args) throws Exception {
    Process p = Runtime.getRuntime().exec("python my_script.py -i \"Hello World!\""); // call your python script here and remember to replace the path if necessary
    BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

    String inputLine;
    while ((inputLine=in.readLine()) != null) {
      System.out.println(inputLine);   // print response from python script
    }
  }
}