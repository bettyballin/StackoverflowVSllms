import java.io.File;

public class ReviewSplitter {
    public static void main(String[] args) {
        ReviewSplitter splitter = new ReviewSplitter();
        splitter.splitReviews();
    }

    public void splitReviews() {
        File[] sortedRevDirs = new File("/path/to/sortedRevDirs").listFiles(); // replace with actual directory
        for (File sortedRevDir : sortedRevDirs) {
            File[] reviews = sortedRevDir.listFiles();
            int numFiles = 90;
            int numTwoThirds = 60;
            int numOneThirds = numFiles - numTwoThirds;

            String trainingDir = sortedRevDir.getAbsolutePath() + "/trainingData";
            File trDir = new File(trainingDir);
            trDir.mkdir();
            String testDir = sortedRevDir.getAbsolutePath() + "/testData";
            File tsDir = new File(testDir);
            tsDir.mkdir();

            int i = 0;
            for (File review : reviews) {
                if (!review.isDirectory()) {
                    if (i < numTwoThirds) {
                        File reviewCopied = new File(trDir + "/" + review.getName());
                        review.renameTo(reviewCopied);
                    } else if (i < numFiles) {
                        File reviewCopied = new File(tsDir + "/" + review.getName());
                        review.renameTo(reviewCopied);
                    }
                    i++;
                }
            }
        }
    }
}