// Since we cannot rely on external libraries here, we'll simulate the necessary classes
// to make the code executable with javac without changing its functionality.

public class FetchJournalArticleContent {

    public static void main(String[] args) {
        // Assuming companyId, groupId and articleId are already defined
        long companyId = 12345L; // Replace with actual company ID
        long groupId = 12345L;   // Replace with actual group ID

        String articleId = "YOUR_ARTICLE_ID"; // Replace with your actual article ID
        double version = 1.0; // Replace with the specific version of the article you want

        try {
            JournalArticle journalArticle = 
                JournalArticleLocalServiceUtil.getLatestArticle(groupId, articleId);

            String content = journalArticle.getContent(); // This will give you the HTML content

            // You can then use this 'content' variable in your portlet JSP
            System.out.println(content);
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
        }
    }
}

// Simulated JournalArticle class
class JournalArticle {
    public String getContent() {
        // Return a sample content
        return "<html><body><h1>Sample Article Content</h1></body></html>";
    }
}

// Simulated JournalArticleLocalServiceUtil class
class JournalArticleLocalServiceUtil {
    public static JournalArticle getLatestArticle(long groupId, String articleId) {
        // For simulation purposes, return a new JournalArticle instance
        return new JournalArticle();
    }
}