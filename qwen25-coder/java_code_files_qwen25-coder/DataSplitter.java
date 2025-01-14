import java.io.File;

public class DataSplitter {

    public static void main(String[] args) {

        File[] reviews = null;

        // Assume that sortedRevDirs are passed as arguments
        if (args.length == 0) {
            System.out.println("Please provide directories to process.");
            return;
        }

        for(String dirPath : args) {
            File sortedRevDir = new File(dirPath);
            if (!sortedRevDir.isDirectory()) {
                System.out.println("The path " + dirPath + " is not a directory.");
                continue;
            }

            int numFiles = 90;
            int numTwoThirds = 60;
            int numOneThird = numFiles - numTwoThirds;

            String trainingDir = sortedRevDir.getAbsolutePath() + "/trainingData";
            File trDir = new File(trainingDir);
            trDir.mkdir();
            String testDir = sortedRevDir.getAbsolutePath() + "/testData";
            File tsDir = new File(testDir);
            tsDir.mkdir();

            // Move files to the training directory
            reviews = sortedRevDir.listFiles(); // Refresh the list of files
            if (reviews == null) {
                System.out.println("Could not list files in directory: " + sortedRevDir.getAbsolutePath());
                continue;
            }

            for(int i = 0; i < numTwoThirds && i < reviews.length; i++) {
                File review = reviews[i];
                if(!review.isDirectory()) {
                    File reviewCopied = new File(trDir, review.getName());
                    review.renameTo(reviewCopied);
                } 
            }

            // Recalculate the list of files in the directory
            reviews = sortedRevDir.listFiles();

            // Move files to the test directory
            for(int j = 0; j < numOneThird && j < reviews.length; j++) {
                File review = reviews[j];
                if(!review.isDirectory()) {
                    File reviewCopied = new File(tsDir, review.getName());
                    review.renameTo(reviewCopied);
                }
            }
        }
    }
}