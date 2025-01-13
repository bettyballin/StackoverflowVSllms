import java.lang.String;
public class DeveloperScorecard {
    private int codeReviewScore;
    private int featureVelocityScore;
    private int codeQualityScore;
    private int pairProgrammingScore;
    private int feedbackScore;

    public DeveloperScorecard(int codeReviewScore, int featureVelocityScore, int codeQualityScore, int pairProgrammingScore, int feedbackScore) {
        this.codeReviewScore = codeReviewScore;
        this.featureVelocityScore = featureVelocityScore;
        this.codeQualityScore = codeQualityScore;
        this.pairProgrammingScore = pairProgrammingScore;
        this.feedbackScore = feedbackScore;
    }

    public int calculateOverallScore() {
        // Assign weights to each score
        double codeReviewWeight = 0.2;
        double featureVelocityWeight = 0.3;
        double codeQualityWeight = 0.2;
        double pairProgrammingWeight = 0.1;
        double feedbackWeight = 0.2;

        // Calculate the overall score
        double overallScore = (codeReviewScore * codeReviewWeight) +
                (featureVelocityScore * featureVelocityWeight) +
                (codeQualityScore * codeQualityWeight) +
                (pairProgrammingScore * pairProgrammingWeight) +
                (feedbackScore * feedbackWeight);

        return (int) overallScore;
    }

	public static void main(String[] args) {
	}
}