/*
 * Decompiled with CFR 0.152.
 */
public class CaseConverter {
    public static String toPascalCase(String string) {
        return CaseConverter.toCamelCase(string, true);
    }

    public static String toCamelCase(String string, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl2 = bl;
        for (char c : string.toCharArray()) {
            if (Character.isLetter(c)) {
                if (bl2) {
                    stringBuilder.append(Character.toUpperCase(c));
                    bl2 = false;
                    continue;
                }
                stringBuilder.append(Character.toLowerCase(c));
                continue;
            }
            if (!Character.isWhitespace(c) && Character.isLetterOrDigit(c)) continue;
            bl2 = true;
        }
        return stringBuilder.toString();
    }

    public static String toCamelCase(String string) {
        return CaseConverter.toCamelCase(string, false);
    }

    public static void main(String[] stringArray) {
        String string = "mynameisfred";
        System.out.println("Camel: " + CaseConverter.toCamelCase(string));
        System.out.println("Pascal: " + CaseConverter.toPascalCase(string));
    }
}
