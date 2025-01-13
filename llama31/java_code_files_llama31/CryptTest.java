/*
 * Decompiled with CFR 0.152.
 */
public class CryptTest {
    public static void main(String[] stringArray) {
        if (stringArray.length != 5) {
            System.err.println("Usage: cryptTest (encrypt|decrypt) key iv algorithm mode");
            System.err.println("Takes input from STDIN. Output goes to STDOUT.");
        } else {
            String string = stringArray[0];
            String string2 = stringArray[1];
            String string3 = stringArray[2];
            String string4 = stringArray[3];
            String string5 = stringArray[4];
            try {
                BlockCrypt blockCrypt = new BlockCrypt(string2, string3, string4, string5);
                if (string.equalsIgnoreCase("encrypt")) {
                    blockCrypt.encrypt(System.in, System.out);
                } else if (string.equalsIgnoreCase("decrypt")) {
                    blockCrypt.decrypt(System.in, System.out);
                } else {
                    System.err.println("Invalid operation. Use (encrypt|decrypt).");
                }
            }
            catch (Exception exception) {
                System.err.println("An error occurred: " + exception.getMessage());
            }
        }
    }
}
