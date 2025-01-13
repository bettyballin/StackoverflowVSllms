/*
 * Decompiled with CFR 0.152.
 */
public class PolylineEncoder {
    private static final String ENCODE_TABLE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";

    public static String encode(int[] nArray) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        for (int n2 : nArray) {
            int n3 = n2 - n;
            n = n2;
            int n4 = 0;
            while (n3 >> n4 > 0) {
                stringBuilder.append(ENCODE_TABLE.charAt((n3 >> n4 & 0x1F) + (n4 > 0 ? 32 : 0)));
                n4 += 5;
            }
        }
        return stringBuilder.toString();
    }

    public static int[] decode(String string) {
        int[] nArray = new int[string.length()];
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < string.length(); ++i) {
            int n3 = 0;
            for (int j = 0; j < 25; j += 5) {
                char c;
                int n4;
                if ((n4 = ENCODE_TABLE.indexOf(c = string.charAt(i++))) < 0) {
                    throw new RuntimeException("Invalid character in encoded polyline: " + c);
                }
                n3 |= (n4 & 0x1F) << j;
                if (n4 >= 32) continue;
                break;
            }
            nArray[n2++] = n += n3 & true ? ~(n3 >> 1) : n3 >> 1;
        }
        return nArray;
    }

    public static void main(String[] stringArray) {
    }
}
