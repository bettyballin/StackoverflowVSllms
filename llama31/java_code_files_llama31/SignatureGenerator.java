/*
 * Decompiled with CFR 0.152.
 */
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class SignatureGenerator {
    public static String generateSignature(String string, String string2, String string3, String string4) throws Exception {
        String string5 = string2 + "\n" + string3 + "\n" + string4;
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(string.getBytes(), "HmacSHA256");
        mac.init(secretKeySpec);
        byte[] byArray = mac.doFinal(string5.getBytes());
        return SignatureGenerator.bytesToHex(byArray);
    }

    private static String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%02x", by));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) throws Exception {
        String string = "your_secret_key";
        String string2 = "GET";
        String string3 = "/path/to/resource";
        String string4 = "{\"key\":\"value\"}";
        String string5 = SignatureGenerator.generateSignature(string, string2, string3, string4);
        System.out.println("Generated Signature: " + string5);
    }
}
