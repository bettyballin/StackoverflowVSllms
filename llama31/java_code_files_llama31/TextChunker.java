/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class TextChunker {
    private static final int LINE_LENGTH = 20;
    private static final int LINES_PER_PAGE = 4;

    public static List<String> chunkText(String string) {
        String[] stringArray;
        ArrayList<String> arrayList = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : stringArray = string.split("\\s+")) {
            int n;
            if (stringBuilder.length() + string2.length() + 1 > 80) {
                arrayList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
            if (stringBuilder.length() % 20 == 0 && stringBuilder.length() != 0) {
                stringBuilder.append("\n");
            }
            if (string2.length() > 20) {
                n = 20 - stringBuilder.length() % 20;
                while (string2.length() > n) {
                    stringBuilder.append(string2.substring(0, n)).append("-\n");
                    string2 = string2.substring(n);
                    n = 20;
                }
                stringBuilder.append(string2);
                continue;
            }
            if (stringBuilder.length() % 20 + string2.length() > 20) {
                n = 20 - stringBuilder.length() % 20;
                stringBuilder.append(string2.substring(0, n)).append("-\n");
                stringBuilder.append(string2.substring(n));
                continue;
            }
            if (stringBuilder.length() != 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(string2);
        }
        arrayList.add(stringBuilder.toString());
        return arrayList;
    }

    public static void main(String[] stringArray) {
        String string = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        List<String> list = TextChunker.chunkText(string);
        for (int i = 0; i < list.size(); ++i) {
            System.out.println("Page " + (i + 1) + ":\n" + list.get(i) + "\n");
        }
    }
}
