import java.lang.String;
import java.sql.ResultSet;

public class None_15 {
    public static void main(String[] args) {
        ResultSet rs = null; // Initialize ResultSet appropriately
        Article newArticle = new Article();

        newArticle.setArticleAuthor(rs.getString("article_name")); // This line seems correct
        newArticle.setArticleBody(rs.getString("article_body"));   // Ensure this field name is correct

        // But then you repeat setArticleAuthor with a different column
        newArticle.setArticleAuthor(rs.getString("article_author"));
    }
}

class Article {
    private String articleAuthor;
    private String articleBody;

    public void setArticleAuthor(String author) {
        this.articleAuthor = author;
    }

    public void setArticleBody(String body) {
        this.articleBody = body;
    }
}