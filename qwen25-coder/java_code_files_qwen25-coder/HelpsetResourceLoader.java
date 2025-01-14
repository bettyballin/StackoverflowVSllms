import java.lang.String;
import java.net.URL;

public class HelpsetResourceLoader {

    URL hsURL;

    {
        hsURL = getClass().getClassLoader().getResource("helpsets/helpset.hs");

        if (hsURL == null) {
            throw new RuntimeException("Resource not found!");
        }
    }

    public static void main(String[] args) {
    }

}