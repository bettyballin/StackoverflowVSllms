import java.io.*;
import javax.net.ssl.HttpsURLConnection;

public class MyClass {
    public static void main(String[] args) {
        DataInputStream din = null;
        InputStream in = null;
        HttpsURLConnection con = null;

        // Close InputStream & HttpsURLConnection:
        try {
            din.close();
            in.close();
        } catch(IOException e1) {}
        // Done with obtaining data? Close both input stream and connection objects!
        con.disconnect(); // Done using this object/connection, free up resources by disconnecting it.
        // It frees up system-level resources associated with the URLConnection rather than closing the underlying socket if one has been established.
    }
}