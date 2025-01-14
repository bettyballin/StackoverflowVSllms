import java.lang.String;
import java.util.Base64;
import java.util.UUID;

public class UUIDTest {

    public static void main(String[] args){
        UUID uuid = UUID.randomUUID();
        System.out.println("UUID String: " + uuid.toString());
        System.out.println("Number of Bytes: " + uuid.toString().getBytes().length);
        System.out.println();

        byte[] uuidArr = asByteArray(uuid);
        System.out.print("UUID Byte Array: ");
        for(byte b: uuidArr){
            System.out.print(b +" ");
        }
        System.out.println();
        System.out.println("Number of Bytes: " + uuidArr.length);
        System.out.println();

        try {
            // Convert a byte array to base64 string
            String s = Base64.getUrlEncoder().withoutPadding().encodeToString(uuidArr);
            System.out.println("UUID Base64 URL Safe String: " + s);
            System.out.println("Number of Bytes: " + s.getBytes().length);
            System.out.println();

            // Convert base64 string to a byte array
            byte[] backArr = Base64.getUrlDecoder().decode(s);
            System.out.print("Back to UUID Byte Array: ");
            for(byte b: backArr){
                System.out.print(b +" ");
            }
            System.out.println();
            System.out.println("Number of Bytes: " + backArr.length);

            System.out.println();
            UUID newUUID = toUUID(backArr);
            System.out.println("UUID String: " + newUUID.toString());
            System.out.println("Number of Bytes: " + newUUID.toString().getBytes().length);
            System.out.println();

            System.out.println("Equal to Start UUID? "+newUUID.equals(uuid));
            if(!newUUID.equals(uuid)){
                throw new IllegalStateException("UUIDs do not match");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] asByteArray(UUID uuid) {
        long msb = uuid.getMostSignificantBits();
        long lsb = uuid.getLeastSignificantBits();
        byte[] buffer = new byte[16];
        for (int i = 0; i < 8; i++) {
            buffer[i] = (byte) (msb >>> 8 * (7 - i));
        }
        for (int i = 8; i < 16; i++) {
            buffer[i] = (byte) (lsb >>> 8 * (15 - i));
        }

        return buffer;
    }

    public static UUID toUUID(byte[] bytes) {
        long msb = 0;
        long lsb = 0;
        assert bytes.length == 16 : "Expected byte array with 16 elements";
        for (int i = 0; i < 8; i++) {
            msb = (msb << 8) | (bytes[i] & 0xff);
        }
        for (int i = 8; i < 16; i++) {
            lsb = (lsb << 8) | (bytes[i] & 0xff);
        }

        return new UUID(msb, lsb);
    }
}