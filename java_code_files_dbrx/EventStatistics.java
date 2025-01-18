public class EventStatistics {
    // Set initial values according to your needs.
    private long totalEvents = 0;
    private long failedEvents = 0;
    private long windowStartTime = System.currentTimeMillis();

    private static final int X = 60; // Desired number of seconds for the statistics window.

    public void handleSuccessEvent() {
        increaseTotalEventCount(true);
    }

    public void handleFailureEvent() {
        increaseTotalEventCount(false);
        failedEvents++;
    }

    /**
     * Updates totalEvents and removes old events from the window if necessary.
     * This should also be called periodically to clean up old events when no new ones come in.
     */
    public void adjustWindow() {
        long currentTime = System.currentTimeMillis();
        while (needToRemoveEvent(windowStartTime, currentTime)) {
            if (!decreaseTotalEventCount()) return; // No longer inside your time window
        }
    }

    private boolean needToRemoveEvent(long start, long current) {
        double difference = toSeconds(current - start);
        return difference > X; // X is your desired number of seconds for the statistics window.
    }

    public void increaseTotalEventCount(boolean wasSuccessful) {
        if (wasSuccessful) totalEvents++;
        adjustWindow();
    }

    private boolean decreaseTotalEventCount() {
        if (!hasOldEnoughData()) return false; // No old events to remove.

        windowStartTime += SECONDS_TO_MILLISECONDS(1); // Remove oldest event from the time window

        totalEvents--; // In general you'll be removing one successful or failed event.
                       // You may need to handle edge cases where this might not behave like you want it to.
        if (randomSuccess()) { // Determine whether you are removing a failure event or not.
            return true; // We removed an old event and can continue processing the time window.
        } else {
            failedEvents--; // If we remove a "failure," adjust our failure count too.
        }
        return true;
    }

    private double toSeconds(long milliseconds) {
        return milliseconds / 1000.0;
    }

    private long SECONDS_TO_MILLISECONDS(int seconds) {
        return seconds * 1000L;
    }

    private boolean hasOldEnoughData() {
        // Placeholder implementation
        // Assuming we always have old enough data
        return true;
    }

    private boolean randomSuccess() {
        // Placeholder implementation
        // Randomly returns true or false
        return Math.random() < 0.5;
    }

    public static void main(String[] args) {
        // You can put test code here if needed
    }
}