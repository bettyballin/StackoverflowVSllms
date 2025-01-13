import java.lang.String;

public class HashFunction {
    public int hash(int key) {
        int a = key + 0x9e3779b9;
        a = (a ^ (a >>> 16)) * 0x85ebca6b;
        a = (a ^ (a >>> 13)) * 0xc2b2ae35;
        return a ^ (a >>> 16);
    }

    public static void main(String[] args) {
        HashFunction hashFunction = new HashFunction();
        System.out.println(hashFunction.hash(12345));
    }
}