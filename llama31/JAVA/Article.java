import java.io.Serializable;

public class Article implements Serializable {
    private String articleName;
    private String articleBody;
    private String articleAuthor;
    private String articleComments;
    private String articleDate;
    private String articleId;

    // getters and setters
    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleBody() {
        return articleBody;
    }

    public void setArticleBody(String articleBody) {
        this.articleBody = articleBody;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleComments() {
        return articleComments;
    }

    public void setArticleComments(String articleComments) {
        this.articleComments = articleComments;
    }

    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public static void main(String[] args) {
    }
}