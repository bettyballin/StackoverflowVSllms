// ParentClass.java
package mypackage;
import java.lang.String;
import java.io.*;
import java.net.*;

public class ParentClass {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Start a subprocess that runs ChildClass
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), "mypackage.ChildClass");

        // Inherit IO to see the output from the child process
        pb.inheritIO();

        Process process = pb.start();

        // Wait for the child process to start listening on the socket
        Thread.sleep(1000);

        try (Socket socket = new Socket("localhost", 12345)) {
            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send a command to the child process
            out.write("Hello from parent!" + System.lineSeparator());
            out.flush();

            // Read response from child process
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Received from child: " + line);
            }
        }

        int exitCode = process.waitFor();
        System.out.println("Child exited with code " + exitCode);
    }
}