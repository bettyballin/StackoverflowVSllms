public class UpgradeHandler {
    private boolean terminationSignalReceived;
    private ApplicationService appService; // assume this is your main application service which needs to be updated

    public void start() {
        while (true) {
            if (terminationSignalReceived()) {
                downloadNewVersion(); // replace with proper implementation based on platform/technology in use
                validateDownloadsAndPrepareEnvironmentForUpgrade(); // e.g., ensure user permissions, backups, fallback procedures are defined and setup correctly

                if (upgradePerformed()) {
                    updateApplicationServiceFlag("Version_20"); // replace this with actual flag/mechanism for updated version control in your env
                } else {
                    revertBackToOldVersion(); // e.g., rollback to previous state or mark application as error status and notify user about failure etc..
                }
                restartApplicationServiceWithNewFlags(); // ensure correct flags/parameters are supplied which should include updated version flag set during upgrade process
            }
        }
    }

    private boolean terminationSignalReceived() {
        // Implement the logic to check if termination signal has been received
        return terminationSignalReceived;
    }

    private void downloadNewVersion() {
        // Implement download logic here
    }

    private void validateDownloadsAndPrepareEnvironmentForUpgrade() {
        // Implement validation and preparation logic here
    }

    private boolean upgradePerformed() {
        // Implement upgrade verification logic here
        return true; // or false based on actual implementation
    }

    private void updateApplicationServiceFlag(String version) {
        // Implement flag/mechanism update logic here
    }

    private void revertBackToOldVersion() {
        // Implement rollback logic here
    }

    private void restartApplicationServiceWithNewFlags() {
        // Implement service restart logic here
    }
}

class ApplicationService {
    // Assume this is your main application service which needs to be updated
}