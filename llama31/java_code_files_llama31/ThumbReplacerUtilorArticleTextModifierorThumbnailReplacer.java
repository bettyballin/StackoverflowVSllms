/*
 * Decompiled with CFR 0.152.
 */
public class ThumbReplacerUtilorArticleTextModifierorThumbnailReplacer {
    public static void main(String[] stringArray) {
        String string = "This is a [thumb1] and this is a [thumb2]";
        String[] stringArray2 = new String[]{"photo1.jpg", "photo2.jpg"};
        String string2 = ThumbReplacer.replaceThumbs(string, stringArray2);
        System.out.println(string2);
    }
}
