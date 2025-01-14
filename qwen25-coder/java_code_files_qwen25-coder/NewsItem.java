class NewsItem {
    private int totalVotes;
    private double sumRating;
    private static final int PRIORITY_THRESHOLD = 10; // Minimum number of votes required to be considered for ranking
    private static final double PRIOR_MEAN = 3.5;      // Neutral rating assumption (e.g., 3.5 stars out of 5)
    private static final double PRIOR_WEIGHT = 20;     // Weight of the prior mean

    public NewsItem(int totalVotes, double sumRating) {
        this.totalVotes = totalVotes;
        this.sumRating = sumRating;
    }

    public boolean isRanked() {
        return totalVotes >= PRIORITY_THRESHOLD;
    }

    // Bayesian average ranking calculation
    public double getBayesianAverageRating() {
        if (!isRanked()) {
            return 0; // Not ranked yet, can be adjusted to the minimum allowed value or a placeholder
        }
        return (sumRating + PRIOR_MEAN * PRIOR_WEIGHT) / (totalVotes + PRIOR_WEIGHT);
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "totalVotes=" + totalVotes +
                ", sumRating=" + sumRating +
                ", bayesianAverageRating=" + getBayesianAverageRating() +
                '}';
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        NewsItem news1 = new NewsItem(10, 45); // 4.5 stars out of 5 based on 10 votes
        NewsItem news2 = new NewsItem(1000, 4995); // Almost a perfect score but more trustable due to high number of reviews

        System.out.println(news1);
        System.out.println(news2);

        // Assuming you'd want to rank these, the one with a Bayesian average closer to 5 is ranked higher
    }
}