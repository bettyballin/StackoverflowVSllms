/*
 * Decompiled with CFR 0.152.
 */
public class NewsItem {
    private int sumOfRatings;
    private int countOfVotes;
    private static final int WEIGHT_CONSTANT = 10;

    public double getWeightedRating() {
        return (double)this.sumOfRatings / (double)this.countOfVotes * ((double)this.countOfVotes / (double)(this.countOfVotes + 10));
    }

    public static void main(String[] stringArray) {
    }
}
