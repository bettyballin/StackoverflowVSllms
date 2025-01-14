import java.lang.String;

public class Author_1 {
    // Define dummy annotations to make the code executable
    public @interface Entity {}

    public @interface BatchSize {
        int size();
    }

    // Using batch fetching in Hibernate configuration
    @Entity
    @BatchSize(size = 10)
    class Author {
        // ...
    }

    public static void main(String[] args) {
    }
}