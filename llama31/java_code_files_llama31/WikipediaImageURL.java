/*
 * Decompiled with CFR 0.152.
 */
public class WikipediaImageURL {
    public static String getImageURL(String string) {
        return "https://commons.wikimedia.org/wiki/File:" + string;
    }

    public static void main(String[] stringArray) {
        String string = "Example.jpg";
        System.out.println(WikipediaImageURL.getImageURL(string));
    }
}
