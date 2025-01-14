import java.lang.String;
// Example of a simple version check and update notification in Java

public class SystemUpdateChecker {
    private String currentVersion;
    private String latestVersion;

    public SystemUpdateChecker(String current, String latest) {
        this.currentVersion = current;
        this.latestVersion = latest;
    }

    public boolean isUpdateAvailable() {
        return !this.currentVersion.equals(this.latestVersion);
    }

    public void notifyUserOfUpdate() {
        if (isUpdateAvailable()) {
            System.out.println("New version " + this.latestVersion + " available. Consider updating.");
        } else {
            System.out.println("You are using the latest version: " + this.currentVersion);
        }
    }

    public static void main(String[] args) {
        SystemUpdateChecker checker = new SystemUpdateChecker("1.2", "1.3");
        checker.notifyUserOfUpdate();
    }
}