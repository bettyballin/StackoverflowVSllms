/*
 * Decompiled with CFR 0.152.
 */
public class Main_616 {
    public static String escapeMySQL(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        block11: for (char c : string.toCharArray()) {
            switch (c) {
                case '\u0000': {
                    stringBuilder.append("\\0");
                    continue block11;
                }
                case '\\': {
                    stringBuilder.append("\\\\");
                    continue block11;
                }
                case '\'': {
                    stringBuilder.append("\\'");
                    continue block11;
                }
                case '\"': {
                    stringBuilder.append("\\\"");
                    continue block11;
                }
                case '\n': {
                    stringBuilder.append("\\n");
                    continue block11;
                }
                case '\r': {
                    stringBuilder.append("\\r");
                    continue block11;
                }
                case '\t': {
                    stringBuilder.append("\\t");
                    continue block11;
                }
                case ';': {
                    stringBuilder.append("\\;");
                    continue block11;
                }
                case ',': {
                    stringBuilder.append("\\,");
                    continue block11;
                }
                default: {
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
        System.out.println(Main_616.escapeMySQL("Hello, World!"));
    }
}
