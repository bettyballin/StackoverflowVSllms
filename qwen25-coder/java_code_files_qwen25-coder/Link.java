// Link.java
public class Link {
    private String url;
    private String description;
    private String category;

    public Link(String url, String description, String category) {
        this.url = url;
        this.description = description;
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}