/*
 * Decompiled with CFR 0.152.
 */
public class NewsItem_1 {
    private int sumOfRatings;
    private int countOfVotes;

    public double getWilsonScore() {
        double d = 1.96;
        double d2 = (double)this.sumOfRatings / (double)this.countOfVotes;
        double d3 = this.countOfVotes;
        return (d2 + d * d / (2.0 * d3)) / (1.0 + d * d / d3);
    }

    public static void main(String[] stringArray) {
    }
}
