import java.io.*;
import java.security.*;
import java.util.*;
import java.util.jar.*;

public class JarSignatureVerifier {
    private final String JAR_NAME;

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java JarSignatureVerifier <jar-name>");
            return;
        }

        JarSignatureVerifier verifier = new JarSignatureVerifier(args[0]);
        boolean verified = verifier.verify();
        System.out.printf("%nThe JAR %s%s valid.%n",
                args[0], (verified) ? " is" : " is NOT");
    }

    // Constructor to initialize the jar file name.
    public JarSignatureVerifier(String jarName) {
        this.JAR_NAME = jarName;
    }

    // To verify digital signature of a specific jar file.
    private boolean verify() throws Exception {
        String baseDir = System.getProperty("user.dir"); // Get user directory or path that running Java program from
        File jarFile = new File(baseDir, this.JAR_NAME);

        JarFile jar;
        try {
            jar = new JarFile(jarFile, true);
        } catch (IOException e) {
            System.out.println("Failed to open JAR: " + e);
            return false;
        }

        Enumeration<JarEntry> entries = jar.entries();

        byte[] buffer = new byte[8192];
        boolean verified = true;
        while (entries.hasMoreElements()) { // Iterating over all elements in JAR.
            JarEntry entry = entries.nextElement();
            // Skip directories
            if (entry.isDirectory()) {
                continue;
            }
            InputStream is = jar.getInputStream(entry);
            try {
                while (is.read(buffer, 0, buffer.length) != -1) {
                    // Read the entry content to trigger the verification
                }
            } catch (SecurityException se) {
                // Signature verification failed
                System.out.println("Signature verification failed for entry: " + entry.getName());
                verified = false;
                break;
            } catch (IOException ioe) {
                System.out.println("I/O error reading entry: " + entry.getName());
                verified = false;
                break;
            } finally {
                is.close();
            }
        }
        jar.close();
        return verified;
    }
}