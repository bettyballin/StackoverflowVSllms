import java.lang.String;

public class ContentGenerator {
    public static void main(String[] args) {
        // Create a new instance of Content
        Content content = new Content("Insert Title Here", "Insert Body Here");
        
        // Note: The request object is typically used in Java Servlets, 
        // but for a simple Java application, we can print the content to the console
        System.out.println(content);
    }
}

// Define the Content class
class Content {
    private String title;
    private String body;

    public Content(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Body: " + body;
    }
}