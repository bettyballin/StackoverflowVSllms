import java.lang.String;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.net.URI;
import java.net.URISyntaxException;

public class UrlVerifier {
    Set<String> approvedDomains = new HashSet<>(Arrays.asList(
        "https://trusted-site.com",
        "http://another-trusted-site.org"
    ));

    public boolean isDomainApproved(String url) {
        try {
            URI uri = new URI(url);
            return approvedDomains.contains(uri.getScheme() + "://" + uri.getHost());
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public static void main(String[] args) {
    }
}