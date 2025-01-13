import java.lang.String;
// JarHasher.java

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JarHasher {
    public static String computeHash(String jarPath) 
            throws IOException, NoSuchAlgorithmException {
        InputStream in = JarHasher.class.getResourceAsStream(jarPath);
        if (in == null) {
            throw new IOException("Jar file not found");
        }

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            md.update(buffer, 0, bytesRead);
        }
        in.close();

        byte[] hashBytes = md.digest();
        return bytesToHex(hashBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

	public static void main(String[] args) {
	}
}