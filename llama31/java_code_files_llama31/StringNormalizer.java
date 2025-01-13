/*
 * Decompiled with CFR 0.152.
 */
public class StringNormalizer {
    public static String normalize(String string) {
        String string2 = string.replaceAll("[^a-zA-Z0-9\\s_-]", "");
        String[] stringArray = string2.split("\\s|_|-");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string3 : stringArray) {
            String string4 = string3.replaceAll("^\\d+", "").substring(0, 1).toUpperCase() + string3.substring(1).toLowerCase();
            stringBuilder.append(string4);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
        System.out.println(StringNormalizer.normalize("the quick brown fox"));
        System.out.println(StringNormalizer.normalize("the_quick_brown_fox"));
        System.out.println(StringNormalizer.normalize("123The_quIck bROWN FOX"));
        System.out.println(StringNormalizer.normalize("the_quick brown fox 123"));
        System.out.println(StringNormalizer.normalize("thequickbrownfox"));
    }
}
