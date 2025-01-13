import java.lang.String;
public class NewsItem {
    private int sumOfRatings;
    private int countOfVotes;
    private static final int WEIGHT_CONSTANT = 10;

    public double getWeightedRating() {
        return (sumOfRatings / (double) countOfVotes) * (countOfVotes / (double) (countOfVotes + WEIGHT_CONSTANT));
    }

	public static void main(String[] args) {
	}
}