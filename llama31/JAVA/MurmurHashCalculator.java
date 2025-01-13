import java.lang.String;

public class MurmurHashCalculator {
    public int hash(int key) {
        int c1 = 0xcc9e2d51;
        int c2 = 0x1b873593;
        int r1 = 15;
        int r2 = 13;
        int m = 5;
        int n = 0xe6546b64;

        int k = key;
        k ^= (k >>> r1);
        k *= c1;
        k ^= (k >>> r2);
        k *= c2;

        int hash = n;
        hash ^= (hash >>> 16);
        hash *= m;
        hash ^= (hash >>> 10);

        return hash ^ k;
    }

    public static void main(String[] args) {
        MurmurHashCalculator calculator = new MurmurHashCalculator();
        int key = 12345; // test key
        int hashedKey = calculator.hash(key);
        System.out.println("Hashed key: " + hashedKey);
    }
}