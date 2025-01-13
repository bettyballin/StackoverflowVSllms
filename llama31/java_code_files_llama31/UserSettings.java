/*
 * Decompiled with CFR 0.152.
 */
public class UserSettings {
    private String username;
    private boolean darkMode;

    public UserSettings(String string, boolean bl) {
        this.username = string;
        this.darkMode = bl;
    }

    public String serialize() {
        return this.username + ":" + (this.darkMode ? "1" : "0");
    }

    public static UserSettings deserialize(String string) {
        String[] stringArray = string.split(":");
        return new UserSettings(stringArray[0], stringArray[1].equals("1"));
    }

    public static void main(String[] stringArray) {
    }
}
