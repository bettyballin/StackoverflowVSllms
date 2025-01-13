/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HtmlFetcher {
    public static void main(String[] stringArray) {
        try {
            String string;
            URL uRL = new URL("http://example.com");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRL.openStream()));
            StringBuilder stringBuilder = new StringBuilder();
            while ((string = bufferedReader.readLine()) != null) {
                stringBuilder.append(string).append("\n");
            }
            bufferedReader.close();
            String string2 = stringBuilder.toString();
            System.out.println(string2);
        }
        catch (MalformedURLException malformedURLException) {
            System.out.println("Invalid URL");
        }
        catch (IOException iOException) {
            System.out.println("Failed to fetch HTML: " + iOException.getMessage());
        }
    }
}
