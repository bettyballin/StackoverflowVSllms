/*
 * Decompiled with CFR 0.152.
 */
public class Main_39 {
    public static String hex2dec(String string) {
        if (!string.matches("^[0-9A-Fa-f]*$")) {
            return "Invalid hexadecimal number";
        }
        if ((string = string.replaceAll("^(0x)?", "")).equals("")) {
            return "0";
        }
        return Integer.toString(Integer.parseInt(string, 16));
    }

    public static void main(String[] stringArray) {
        System.out.println(Main_39.hex2dec("0x10"));
    }
}
