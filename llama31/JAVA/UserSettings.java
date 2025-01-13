import java.lang.String;
// Custom format for storing user settings
public class UserSettings {
    private String username;
    private boolean darkMode;

    public UserSettings(String username, boolean darkMode) {
        this.username = username;
        this.darkMode = darkMode;
    }

    public String serialize() {
        return username + ":" + (darkMode ? "1" : "0");
    }

    public static UserSettings deserialize(String data) {
        String[] parts = data.split(":");
        return new UserSettings(parts[0], parts[1].equals("1"));
    }

	public static void main(String[] args) {
	}
}