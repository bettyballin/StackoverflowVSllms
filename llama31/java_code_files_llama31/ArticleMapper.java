/*
 * Decompiled with CFR 0.152.
 */
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleMapper {
    public static void mapArticle(ResultSet resultSet) throws SQLException {
        Article article = new Article();
        article.setArticleAuthor(resultSet.getString("article_author"));
    }

    public static void main(String[] stringArray) {
    }
}
