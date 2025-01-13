/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class HtmlFileLoader {
    public static void main(String[] stringArray) {
        HtmlFileLoader htmlFileLoader = new HtmlFileLoader();
    }

    public HtmlFileLoader() {
        File file = new File("path/to/yourpage.html");
        try {
            URL uRL = file.toURI().toURL();
        }
        catch (MalformedURLException malformedURLException) {
            System.out.println("Error creating URL: " + malformedURLException.getMessage());
        }
    }
}
