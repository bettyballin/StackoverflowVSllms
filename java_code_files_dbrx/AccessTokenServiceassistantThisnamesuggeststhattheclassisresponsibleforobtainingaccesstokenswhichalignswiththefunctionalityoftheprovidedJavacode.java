import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessTokenService {

    private static final String solutionName = "yourSolutionName";
    private static final String password = "yourPassword";
    private static final Logger log = LoggerFactory.getLogger(AccessTokenService.class);

    public static String call() {
        try {
            HttpClient client = new HttpClient();
            String uri = String.format("https://accesscontrol.windows.net/issuetoken.aspx?u=%s&p=%s",
                    URLEncoder.encode(solutionName, StandardCharsets.UTF_8),
                    URLEncoder.encode(password, StandardCharsets.UTF_8));
            log.debug("Outgoing URI is : " + uri);
            GetMethod get = new GetMethod(uri);
            int status = client.executeMethod(get);
            byte[] responseBody = get.getResponseBody();
            log.debug("Status returned is : " + status);
            if (status == HttpStatus.SC_OK) {
                return new String(responseBody, StandardCharsets.UTF_8);
            }
        } catch (Exception ex) {
            log.error("Error while calling Access Control portal.", ex);
        }
        return null;
    }

    public static void main(String[] args) {
        String token = call();
        System.out.println("Access token: " + token);
    }
}