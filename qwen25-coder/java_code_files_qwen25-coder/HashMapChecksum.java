import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class HashMapChecksum {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", 123);

        byte[] serializedMap = serialize(map);
        String checksum = getChecksum(serializedMap);

        System.out.println("Checksum: " + checksum);
    }

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }

    public static String getChecksum(byte[] bytes) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(bytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }
}