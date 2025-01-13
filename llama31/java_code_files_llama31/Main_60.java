/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main_60 {
    public static void main(String[] stringArray) throws IOException, NoSuchAlgorithmException {
        File file = new File("path/to/file");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] byArray = messageDigest.digest(Main_60.getFileContents(file));
        String string = Main_60.bytesToHex(byArray);
        String string2 = Main_60.bytesToHex(messageDigest.digest(Main_60.getFileContents(file)));
        if (!string2.equals(string)) {
            System.out.println("File has changed");
        }
    }

    private static byte[] getFileContents(File file) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file);){
            byte[] byArray = new byte[(int)file.length()];
            fileInputStream.read(byArray);
            byte[] byArray2 = byArray;
            return byArray2;
        }
    }

    private static String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            String string = Integer.toHexString(0xFF & by);
            if (string.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
