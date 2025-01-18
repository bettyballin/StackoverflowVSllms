import java.lang.String;
import java.awt.*;
import javax.swing.*;
import java.nio.file.*;
import java.io.*;
import javax.imageio.*;

public class Main_374 {
    public static void main(String[] args) throws IOException, Exception {
        byte[] fileBytes = Files.readAllBytes(Paths.get("yourImageFile.jpg")); // Read the image into memory with original header intact
        byte[] obfuscatedBytes = alterHeader(fileBytes); // Alter the bytes 7-10 in "obfuscatedBytes" as your mentioned and return it

        ByteArrayInputStream in = new ByteArrayInputStream(obfuscatedBytes);
        Image image = ImageIO.read(in); // Read image from altered byte array without saving to disk again
        JFrame frame = new JFrame();
        frame.getContentPane().add(new JLabel(new ImageIcon(image)));
        frame.setSize(640, 480);
        frame.setVisible(true);
    }

    private static byte[] alterHeader(byte[] fileBytes) {
      // This is where you would change bytes 7-10 in the fileBytes array
      // You will need to handle endianness and other potential complications here, since this method depends on your exact implementation.
        return null;
    }
}