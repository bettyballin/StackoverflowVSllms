public class None_10 {
    public static void main(String[] args) {
        byte[] header = {(byte) 0xFF, (byte) 0xD8}; // Example header bytes
        String hex = toHexString(header).replace("-", ""); // Result: "ffd8"
        System.out.println(hex);
    }

    // Method to convert byte array to hex string with dashes
    public static String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02x", bytes[i]));
            if (i < bytes.length - 1) {
                sb.append("-");
            }
        }
        return sb.toString();
    }
}