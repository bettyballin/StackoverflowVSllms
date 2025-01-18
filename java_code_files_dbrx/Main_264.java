import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Obtain the connection object (assuming a URL connection for demonstration)
            URL url = new URL("http://example.com");
            URLConnection con = url.openConnection();

            InputStream in = con.getInputStream();          // Get input Stream from Connection object obtained above!
            DataInputStream din;                            // DataInputStream for obtaining textual information/objects of varying types - Primitive(int, boolean, ...)
            din = new DataInputStream(in);                  // Create a data stream on this input stream.
            System.out.println("Data: " + din.readUTF());   // Read the data from input data stream and print it to std out!
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}