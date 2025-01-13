public class StringHashCalculator {
    public static void main(String[] args) {
        String str = "Hello, World!";
        int hash = calculateHash(str.toCharArray());
        System.out.println("Hash: " + hash);
    }

    public static int calculateHash(char[] value) {
        int hash = 0;
        int length = value.length;
        for (int i = 0; i < length; i++) {
            hash = 31 * hash + value[i];
        }
        return hash;
    }
}