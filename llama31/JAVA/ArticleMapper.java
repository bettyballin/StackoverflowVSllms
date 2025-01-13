import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleMapper {
    public static void mapArticle(ResultSet rs) throws SQLException {
        Article ewArticle = new Article();
        ewArticle.setArticleAuthor(rs.getString("article_author"));
    }

    public static void main(String[] args) {
    }
}

class Article {
    private String articleAuthor;

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }
}