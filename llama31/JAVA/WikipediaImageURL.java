import java.lang.String;
public class WikipediaImageURL {
    public static String getImageURL(String imageName) {
        return "https://commons.wikimedia.org/wiki/File:" + imageName;
    }

    public static void main(String[] args) {
        String imageName = "Example.jpg";
        System.out.println(getImageURL(imageName));
    }
}