/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Main_282 {
    public static void main(String[] stringArray) throws Exception {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Customer1");
        arrayList.add("Customer2");
        SecretKeySpec secretKeySpec = new SecretKeySpec(Main_282.generateRandomKey(32), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeySpec);
        byte[] byArray = cipher.doFinal(Main_282.serialize(arrayList));
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        byte[] byArray2 = mac.doFinal(byArray);
        if (Main_282.verifySignature(byArray, byArray2, secretKeySpec)) {
            byte[] byArray3 = Main_282.decrypt(byArray, secretKeySpec);
            ArrayList<String> arrayList2 = Main_282.deserialize(byArray3);
            System.out.println(arrayList2);
        }
    }

    public static byte[] generateRandomKey(int n) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[n];
        secureRandom.nextBytes(byArray);
        return byArray;
    }

    public static byte[] serialize(ArrayList<String> arrayList) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(arrayList);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static ArrayList<String> deserialize(byte[] byArray) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (ArrayList)objectInputStream.readObject();
    }

    public static boolean verifySignature(byte[] byArray, byte[] byArray2, SecretKeySpec secretKeySpec) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        byte[] byArray3 = mac.doFinal(byArray);
        return Arrays.equals(byArray2, byArray3);
    }

    public static byte[] decrypt(byte[] byArray, SecretKeySpec secretKeySpec) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(byArray);
    }
}
