import java.lang.String;
import java.io.File;
public class FileMover {
    public static void main(String[] args) {
        int numTwoThirds = 0;
        File[] reviews = new File[0];
        int numFiles = reviews.length;
        String tsDir = ".";

        for(int j = numTwoThirds; j < numFiles; j++) { // change here
            File review = reviews[j];
            if(!review.isDirectory()) {
                File reviewCopied = new File(tsDir + "/" + review.getName());
                review.renameTo(reviewCopied);
            }
        }
    }
}