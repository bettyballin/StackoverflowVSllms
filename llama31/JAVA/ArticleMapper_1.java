import java.lang.String;

public class ArticleMapper_1_1 {
    public static void main(String[] args) {
        // You need an instance of Article to call setArticleName
        Article ewArticle = new Article();
        // You need a ResultSet instance to call getString
        // For demonstration purposes, assume we have a valid ResultSet
        // ResultSet rs = statement.executeQuery("SELECT * FROM articles");
        // Since we can't execute a SQL query here, we'll just comment it out
        // ewArticle.setArticleName(rs.getString("article_name"));
    }
}

// You need an Article class with a setArticleName method
class Article {
    private String articleName;

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }
}