public class Main_39 {
    public static String hex2dec(String hex) {
        if (!hex.matches("^[0-9A-Fa-f]*$")) {
            return "Invalid hexadecimal number";
        }
        hex = hex.replaceAll("^(0x)?", "");
        if (hex.equals("")) {
            return "0";
        }
        return Integer.toString(Integer.parseInt(hex, 16));
    }

    public static void main(String[] args) {
        System.out.println(hex2dec("0x10")); // Example usage
    }
}