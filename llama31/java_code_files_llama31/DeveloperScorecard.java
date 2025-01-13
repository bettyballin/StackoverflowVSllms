/*
 * Decompiled with CFR 0.152.
 */
public class DeveloperScorecard {
    private int codeReviewScore;
    private int featureVelocityScore;
    private int codeQualityScore;
    private int pairProgrammingScore;
    private int feedbackScore;

    public DeveloperScorecard(int n, int n2, int n3, int n4, int n5) {
        this.codeReviewScore = n;
        this.featureVelocityScore = n2;
        this.codeQualityScore = n3;
        this.pairProgrammingScore = n4;
        this.feedbackScore = n5;
    }

    public int calculateOverallScore() {
        double d = 0.2;
        double d2 = 0.3;
        double d3 = 0.2;
        double d4 = 0.1;
        double d5 = 0.2;
        double d6 = (double)this.codeReviewScore * d + (double)this.featureVelocityScore * d2 + (double)this.codeQualityScore * d3 + (double)this.pairProgrammingScore * d4 + (double)this.feedbackScore * d5;
        return (int)d6;
    }

    public static void main(String[] stringArray) {
    }
}
