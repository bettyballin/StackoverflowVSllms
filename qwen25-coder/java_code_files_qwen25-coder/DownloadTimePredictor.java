import java.lang.String;
import java.time.Duration;
import java.time.LocalDateTime;

public class DownloadTimePredictor {
    private LocalDateTime startTime;
    private double lastPercentDone;

    public DownloadTimePredictor() {
        startTime = LocalDateTime.now();
        lastPercentDone = 0.0;
    }

    public Duration predictRemainingTime(double percentDone) {
        if (percentDone <= lastPercentDone || percentDone < 0 || percentDone > 100) {
            throw new IllegalArgumentException("Invalid percent done value");
        }

        double elapsedTimeInSeconds = Duration.between(startTime, LocalDateTime.now()).toSeconds();
        double rateOfCompletionPerSec = percentDone / elapsedTimeInSeconds;

        double remainingPercentage = 100 - percentDone;
        long estimatedRemainingTimeInSeconds = (long) Math.floor(remainingPercentage / rateOfCompletionPerSec);

        lastPercentDone = percentDone;
        return Duration.ofSeconds(estimatedRemainingTimeInSeconds);
    }

    public void reset() {
        startTime = LocalDateTime.now();
        lastPercentDone = 0.0;
    }

	public static void main(String[] args) {
	}
}