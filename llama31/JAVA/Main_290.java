public class Main_290 {
    public static void main(String[] args) {
        byte[] bytes = {1, 2, 3, 4, 5};
        String hex = bytesToHex(bytes);
        System.out.println(hex);  // Outputs: 0102030405
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}