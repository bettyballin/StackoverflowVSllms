import java.io.*;

public class MyClass {
    public static String jimpsw; // Assuming jimpsw is set elsewhere

    public static void main(String[] args) throws Exception {
        String[] command = {"su", "-", "ji", "-c", "/bin/ls ~bo"};
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.redirectErrorStream(true);
        Process p = pb.start();
        OutputStream stdin = p.getOutputStream();
        stdin.write((jimpsw + "\n").getBytes()); // Write ji's password to process input stream
        stdin.flush();  // Ensure that the flush is called or use a PrintWriter instead of OutputStream
    }
}