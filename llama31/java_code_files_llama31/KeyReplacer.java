/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;

public class KeyReplacer {
    public static String replaceKeys(String string, Map<String, String> map) {
        int n;
        StringBuilder stringBuilder = new StringBuilder(string.length());
        int n2 = 0;
        while ((n = string.indexOf(64, n2)) != -1) {
            int n3 = string.indexOf(64, n + 1);
            if (n3 == -1) {
                throw new RuntimeException("Unbalanced key in template");
            }
            String string2 = string.substring(n + 1, n3);
            String string3 = map.get(string2);
            if (string3 == null) {
                throw new RuntimeException("Unknown key: " + string2);
            }
            stringBuilder.append(string.substring(n2, n));
            stringBuilder.append(string3);
            n2 = n3 + 1;
        }
        stringBuilder.append(string.substring(n2));
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
        String string = "Hello, @name@!";
        Map<String, String> map = Map.of("name", "John");
        System.out.println(KeyReplacer.replaceKeys(string, map));
    }
}
