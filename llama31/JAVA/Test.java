import java.lang.String;
import java.io.*;
public class Test {
public static void main(String[] args) throws Exception {
    Process proc = Runtime.getRuntime().exec("dir");
    proc.waitFor();

    InputStream is = proc.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);

    String line;
    while ( (line = br.readLine()) != null)
        System.out.println(line);

    proc.waitFor();
    System.out.println("exit: " + proc.exitValue());
    proc.destroy();
}
}