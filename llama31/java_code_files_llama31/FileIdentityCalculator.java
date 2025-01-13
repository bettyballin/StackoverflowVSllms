/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileIdentityCalculator {
    private static final int SAMPLE_SIZE = 4096;
    private static final int NUM_SAMPLES = 3;

    public static String calculateFileIdentity(File file) throws IOException {
        long l = file.length();
        byte[] byArray = new byte[12288];
        try (Object object = new FileInputStream(file);){
            ((FileInputStream)object).read(byArray, 0, 4096);
            ((FileInputStream)object).skip(l / 2L - 2048L);
            ((FileInputStream)object).read(byArray, 4096, 4096);
            ((FileInputStream)object).skip(l - 4096L);
            ((FileInputStream)object).read(byArray, 8192, 4096);
        }
        try {
            object = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException);
        }
        byte[] byArray2 = ((MessageDigest)object).digest(byArray);
        String string = Long.toString(l);
        byte[] byArray3 = (string + FileIdentityCalculator.bytesToHex(byArray2)).getBytes();
        ((MessageDigest)object).update(byArray3);
        byte[] byArray4 = ((MessageDigest)object).digest();
        return FileIdentityCalculator.bytesToHex(byArray4);
    }

    private static String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%02x", by));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
        try {
            File file = new File("path_to_your_file");
            System.out.println(FileIdentityCalculator.calculateFileIdentity(file));
        }
        catch (IOException iOException) {
            System.err.println(iOException.getMessage());
        }
    }
}
