import java.io.*;
import java.security.*;

public class Example_6 {
    public static void main(String[] args) throws Exception {
        // get your data using an input stream ... we'll just use a file for example sake, though
        FileInputStream in = new FileInputStream("largefile.dat");
        MessageDigest sha1 = null;
        try {
            sha1 = MessageDigest.getInstance("SHA-1"); // specify the algorithm here!
        } catch (NoSuchAlgorithmException e) {
             throw new BaseException(e);
        }

        byte[] buffer = new byte[8 * 1024]; // whatever your preferred block size is - this means we read 8k at a time.
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            sha1.update(buffer, 0, bytesRead); // update the digest each iteration
        }
    }
}

class BaseException extends Exception {
    public BaseException(Throwable cause) {
        super(cause);
    }
}