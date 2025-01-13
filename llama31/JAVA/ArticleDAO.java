import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ArticleDAO {
    public ArrayList<Article> getArticles() {
        baseIO mySql = new baseIO();
        ArrayList<Article> articleList = new ArrayList<Article>();
        int articleId = 0;

        try {
            String sql = "select * from jsp_blog_article order by article_id Desc Limit 3";
            Connection con = mySql.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Article newArticle = new Article();
                newArticle.setArticleName(rs.getString("article_name"));
                newArticle.setArticleBody(rs.getString("article_body"));
                newArticle.setArticleAuthor(rs.getString("article_author"));
                newArticle.setArticleDate(rs.getString("article_date"));
                articleId = Integer.parseInt(rs.getString("article_id"));
                newArticle.setArticleId(String.valueOf(articleId));
                newArticle.setArticleComments(this.getCommentsNum(articleId));
                articleList.add(newArticle);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            return null;
        }

        return articleList;
    }

    public static void main(String[] args) {
        ArticleDAO articleDAO = new ArticleDAO();
        articleDAO.getArticles();
    }
}

class Article {
    private String articleName;
    private String articleBody;
    private String articleAuthor;
    private String articleDate;
    private String articleId;
    private String articleComments;

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

    public String getArticleComments() {
        return articleComments;
    }

    public void setArticleComments(String articleComments) {
        this.articleComments = articleComments;
    }
}

class baseIO {
    public Connection getConnection() {
        // implement your database connection logic here
        return null;
    }
}