import java.lang.String;

public class HashGenerator {
    public int customHash(long id1, long id2) {
        int hash = (int) (id1 ^ (id2 << 16) ^ (id2 >>> 16));
        return hash;
    }

    public static void main(String[] args) {
        HashGenerator hashGenerator = new HashGenerator();
        long id1 = 12345;
        long id2 = 67890;
        int hash = hashGenerator.customHash(id1, id2);
        System.out.println("Custom Hash: " + hash);
    }
}