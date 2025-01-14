import java.lang.String;
import java.io.Serializable;
public class Article_1 implements Serializable {
    private String articleName;
    private String articleBody;
    private String articleAuthor;
    private String articleComments;
    private String articleDate;
    private String articleId;

    public Article_1() {}

    // Example for one setter and getter
    public void setArticleName(String name) {
        this.articleName = name;
    }

    public String getArticleName() {
        return articleName;
    }

    // Implement all other getters and setters similarly
    public void setArticleBody(String body) {
        this.articleBody = body;
    }

    public String getArticleBody() {
        return articleBody;
    }

    public void setArticleAuthor(String author) {
        this.articleAuthor = author;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleComments(String comments) {
        this.articleComments = comments;
    }

    public String getArticleComments() {
        return articleComments;
    }

    public void setArticleDate(String date) {
        this.articleDate = date;
    }

    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleId(String id) {
        this.articleId = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public static void main(String[] args) {
    }
}