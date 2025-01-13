import java.lang.String;

public class ButtonPressRecorder {
    long[] buttonPressTimes = new long[100]; // initialize array to store button press times
    int index = 0; // index to keep track of array position

    // Method to record button press time
    public void recordButtonPress() {
        // When a button is pressed, record the current time
        buttonPressTimes[index] = System.currentTimeMillis();
        index++;
    }

    public static void main(String[] args) {
        ButtonPressRecorder recorder = new ButtonPressRecorder();
        recorder.recordButtonPress();
    }
}