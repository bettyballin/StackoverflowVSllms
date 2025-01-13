import java.lang.String;

public class ThumbReplacerUtilorArticleTextModifierorThumbnailReplacer {
    public static void main(String[] args) {
        String articleText = "This is a [thumb1] and this is a [thumb2]";
        String[] photos = new String[] {"photo1.jpg", "photo2.jpg"};
        String replacedText = ThumbReplacer.replaceThumbs(articleText, photos);
        System.out.println(replacedText);
    }
}

class ThumbReplacer {
    public static String replaceThumbs(String articleText, String[] photos) {
        for (int i = 0; i < photos.length; i++) {
            articleText = articleText.replace("[thumb" + (i + 1) + "]", photos[i]);
        }
        return articleText;
    }
}