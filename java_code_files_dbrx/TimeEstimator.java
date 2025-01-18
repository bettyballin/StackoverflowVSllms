public class TimeEstimator {
    static int totalLines;
    static int completedLines;
    static double elapsedTime;

    static int remainingLines = totalLines - completedLines;
    static double averageTimePerLine = elapsedTime / completedLines;
    static double estimatedRemainingTime = remainingLines * averageTimePerLine;

    public static void main(String[] args) {
    }
}