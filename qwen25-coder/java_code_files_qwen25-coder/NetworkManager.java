import java.lang.String;
import android.content.ContentResolver;
import android.provider.Settings;

public class NetworkManager {
    /**
     * Enables or disables auto-sync.
     *
     * @param isEnabled set true to enable auto sync, false otherwise
     */
    public void setAutoSyncEnabled(boolean isEnabled) {
        ContentResolver.setMasterSyncAutomatically(isEnabled);
    }
    
    /**
     * Checks if auto-sync is currently enabled.
     *
     * @return true if auto sync is enabled, false otherwise
     */
    public boolean getAutoSyncEnabled() {
        return ContentResolver.getMasterSyncAutomatically();
    }

    // Note: For Background Data/Network data usage, Android has changed the way it manages this over time. 
    // From API 14 (Android ICS) onwards, you should manage network requests more explicitly.

	public static void main(String[] args) {
	}
}