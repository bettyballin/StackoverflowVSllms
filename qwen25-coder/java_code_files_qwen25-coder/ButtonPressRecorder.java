import java.util.ArrayList;
import java.util.List;

public class ButtonPressRecorder {
    private List<Long> buttonPressTimes = new ArrayList<>();

    // Method to record the time when the button is pressed
    public void recordButtonPress() {
        long currentTime = System.nanoTime(); // Record current time in nanoseconds
        buttonPressTimes.add(currentTime);
    }

    // Method to playback recorded button press times
    public void playBackButtonPresses(long startTime) {
        for (Long pressTime : buttonPressTimes) {
            long elapsedTimeSinceStart = pressTime - startTime;
            try {
                Thread.sleep(elapsedTimeSinceStart / 1_000_000); // Convert nanos to millis for sleep
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Playback interrupted");
            }
            highlightButtonState(); // Call method to highlight button state
        }
    }

    // Placeholder method for highlighting the button states
    private void highlightButtonState() {
        System.out.println("Button highlighted at " + System.nanoTime());
    }

    public static void main(String[] args) throws InterruptedException {
        ButtonPressRecorder recorder = new ButtonPressRecorder();

        // Simulate recording button presses
        recorder.recordButtonPress();
        Thread.sleep(100); // simulate some delay
        recorder.recordButtonPress();
        Thread.sleep(250); // simulate more delay

        // Start playback from the initial recorded time
        recorder.playBackButtonPresses(recorder.buttonPressTimes.get(0));
    }
}