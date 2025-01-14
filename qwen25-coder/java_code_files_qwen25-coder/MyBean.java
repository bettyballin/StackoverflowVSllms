import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Define the Name annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Name {
    String value();
}

@Name("myBean")
public class MyBean {
    private String articleContent;
    private boolean isContentLoaded = false;

    public void loadArticleContent() {
        // Simulate fetching heavy data from database or other sources
        this.articleContent = "Large content loaded on demand!";
        this.isContentLoaded = true;
    }

    public String getArticleTitle() {
        return "Click here to read the article";
    }

    public boolean isContentLoaded() {
        return isContentLoaded;
    }

    public String getArticleContent() {
        return articleContent == null ? "" : articleContent;
    }

    public static void main(String[] args) {
        // You can add code here to test the MyBean class if needed
    }
}