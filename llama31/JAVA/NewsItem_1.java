import java.lang.String;
public class NewsItem_1 {
    private int sumOfRatings;
    private int countOfVotes;

    public double getWilsonScore() {
        double z = 1.96; // 95% confidence interval
        double p = (sumOfRatings / (double) countOfVotes);
        double n = countOfVotes;
        return (p + (z * z) / (2 * n)) / (1 + (z * z) / n);
    }

	public static void main(String[] args) {
	}
}