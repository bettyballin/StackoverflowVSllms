import java.util.Date;
import java.util.List;

public class FeedEntry {
    private String title;
    private String link;
    private Date publishedDate;
    private String summary;
    private List<String> authors; // List to accommodate multiple authors if needed
    private List<String> categories; // Categories or tags
    private String id;
    private Date updatedDate;
    private String content;

    // Getters and setters would go here

    public FeedEntry(String title, String link, Date publishedDate, String summary,
                     List<String> authors, List<String> categories, String id,
                     Date updatedDate, String content) {
        this.title = title;
        this.link = link;
        this.publishedDate = publishedDate;
        this.summary = summary;
        this.authors = authors;
        this.categories = categories;
        this.id = id;
        this.updatedDate = updatedDate;
        this.content = content;
    }

    public static void main(String[] args) {
    }
}