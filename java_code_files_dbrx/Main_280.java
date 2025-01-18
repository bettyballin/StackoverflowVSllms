import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class DatabaseRow {
    private String title;
    private boolean hasImage;

    public DatabaseRow(String title, boolean hasImage) {
        this.title = title;
        this.hasImage = hasImage;
    }

    public boolean has_image() {
        return hasImage;
    }

    public String getTitle() {
        return title;
    }
}

public class Main {
    public static void main(String[] args) {
        List<DatabaseRow> mySQLResult = new ArrayList<>(); // Your raw MySQL result here ...

        // Sample data for demonstration purposes
        mySQLResult.add(new DatabaseRow("Article 1", false));
        mySQLResult.add(new DatabaseRow("Article 2", true));
        mySQLResult.add(new DatabaseRow("Article 3", false));

        DatabaseRow withImageNewsArticle = null;
        for (DatabaseRow article : mySQLResult) {
            if (withImageNewsArticle == null && article.has_image()) {
                withImageNewsArticle = article;
            }
        }

        mySQLResult.remove(withImageNewsArticle); // Remove the found article with image from array

        Collections.sort(mySQLResult, new Comparator<DatabaseRow>() {
            @Override
            public int compare(DatabaseRow o1, DatabaseRow o2) {
                // Your custom sorting criteria here
                return o1.getTitle().compareTo(o2.getTitle());
            }
        }); // Sort array without considering images for rest of articles

        // Prepend the removed article with image on top again for final result:
        final List<DatabaseRow> finalResults = new ArrayList<>();
        if (withImageNewsArticle != null) {
            finalResults.add(withImageNewsArticle);
        }
        finalResults.addAll(mySQLResult);

        // Output the final results
        for (DatabaseRow article : finalResults) {
            System.out.println(article.getTitle() + " (Has image: " + article.has_image() + ")");
        }
    }
}