/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class ReviewSplitter {
    public static void main(String[] stringArray) {
        ReviewSplitter reviewSplitter = new ReviewSplitter();
        reviewSplitter.splitReviews();
    }

    public void splitReviews() {
        File[] fileArray;
        for (File file : fileArray = new File("/path/to/sortedRevDirs").listFiles()) {
            File[] fileArray2 = file.listFiles();
            int n = 90;
            int n2 = 60;
            int n3 = n - n2;
            String string = file.getAbsolutePath() + "/trainingData";
            File file2 = new File(string);
            file2.mkdir();
            String string2 = file.getAbsolutePath() + "/testData";
            File file3 = new File(string2);
            file3.mkdir();
            int n4 = 0;
            for (File file4 : fileArray2) {
                if (file4.isDirectory()) continue;
                if (n4 < n2) {
                    var19_19 = new File(String.valueOf(file2) + "/" + file4.getName());
                    file4.renameTo(var19_19);
                } else if (n4 < n) {
                    var19_19 = new File(String.valueOf(file3) + "/" + file4.getName());
                    file4.renameTo(var19_19);
                }
                ++n4;
            }
        }
    }
}
