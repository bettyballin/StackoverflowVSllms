/*
 * Decompiled with CFR 0.152.
 */
import java.util.prefs.Preferences;

public class TwitterPasswordSaver {
    private static String encrypt(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : string.toCharArray()) {
            stringBuilder.append(c + '\u0001');
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
        String string = "your_twitter_password";
        Preferences preferences = Preferences.userNodeForPackage(TwitterPasswordSaver.class);
        String string2 = TwitterPasswordSaver.encrypt(string);
        preferences.put("twitter.password", string2);
        System.out.println("Encrypted password stored.");
    }
}
