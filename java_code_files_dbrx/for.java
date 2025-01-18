import java.lang.String;
import java.lang.Integer;
import java.sql.ResultSet; // For ResultSet
import java.util.List; // For List
import java.util.ArrayList; // For ArrayList

public class MyClass {

    public static void main(String[] args) throws Exception {
        // We need to declare 'rs' as a ResultSet
        ResultSet rs = null; // Placeholder, should be initialized properly
        // Similarly, declare 'articleList'
        List<Article> articleList = new ArrayList<Article>();

        MyClass myClass = new MyClass();

        while (rs.next()) {
            Article newArticle = new Article();
            int articleId = Integer.parseInt(rs.getString("article_id")); // Parse id once and use for comments as well
            newArticle.setArticleAuthor(rs.getString("article_name")); // Make sure this is the expected column name (author or author's name?)
            newArticle.setArticleBody(rs.getString("article_body"));
            newArticle.setArticleDate(rs.getString("article_date"));
            newArticle.setArticleAuthor(rs.getString("article_author")); // Correct call to set article author name
            newArticle.setArticleId(String.valueOf(articleId));
            newArticle.setArticleCommentCount(myClass.getCommentsNum(articleId)); // Assuming getCommentsNum returns comment count, it seems more appropriate to use setter with this name or rename 'getComments()' method in Article class for clarity.
            articleList.add(newArticle);
        }
    }

    // Placeholder method for getCommentsNum
    public int getCommentsNum(int articleId) {
        // Dummy implementation
        return 0;
    }

    // Declare Article class
    public static class Article {
        // Fields
        private String articleAuthor;
        private String articleBody;
        private String articleDate;
        private String articleId;
        private int articleCommentCount;

        // Add methods used in code
        public void setArticleAuthor(String author) {
            this.articleAuthor = author;
        }
        public void setArticleBody(String body) {
            this.articleBody = body;
        }
        public void setArticleDate(String date) {
            this.articleDate = date;
        }
        public void setArticleId(String id) {
            this.articleId = id;
        }
        public void setArticleCommentCount(int count) {
            this.articleCommentCount = count;
        }
    }
}