import java.lang.String;
import java.net.URI;
import java.net.URISyntaxException;

public class DomainParser {
    public static String getDomain(String url) throws URISyntaxException {
        URI uri = new URI(url);
        return uri.getHost();
    }

    public static void main(String[] args) throws URISyntaxException {
        System.out.println(getDomain("http://google.com/dhasjkdas/sadsdds/sdda/sdads.html"));
        System.out.println(getDomain("http://www.google.com/dhasjkdas/sadsdds/sdda/sdads.html"));
        System.out.println(getDomain("http://google.co.uk/dhasjkdas/sadsdds/sdda/sdads.html"));
    }
}