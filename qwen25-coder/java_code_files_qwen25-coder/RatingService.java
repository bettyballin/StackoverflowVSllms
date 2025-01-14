import java.lang.String;
public class RatingService {

    public String getRating(String movieName, String preferredSupplier) {
        switch (preferredSupplier.toLowerCase()) {
            case "imdb":
                return getIMDbRating(movieName);
            case "metacritic":
                return getMetacriticRating(movieName);
            default:
                throw new IllegalArgumentException("Unsupported rating supplier: " + preferredSupplier);
        }
    }

    private String getIMDbRating(String movieName) {
        // Logic to fetch rating from IMDb
        // Use API calls, handle exceptions etc.
        return "IMDb Rating"; // Placeholder return value
    }

    private String getMetacriticRating(String movieName) {
        // Logic to fetch rating from Metacritic
        // This might involve web scraping or API calls
        return "Metacritic Rating"; // Placeholder return value
    }

	public static void main(String[] args) {
	}
}