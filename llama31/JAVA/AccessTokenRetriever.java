import java.lang.String;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;

public class AccessTokenRetriever {
    private static final Logger log = Logger.getLogger(AccessTokenRetriever.class);

    public static String call() {
        try {
            HttpClient client = new HttpClient();
            String uri = "https://accesscontrol.windows.net/isssuetoken.aspx";
            PostMethod post = new PostMethod(uri);
            post.addParameter("u", "solutionname");
            post.addParameter("p", "password");
            int status = client.executeMethod(post);
            byte[] responseBody = post.getResponseBody();
            if (status == HttpStatus.SC_OK) {
                return new String(responseBody);
            }
        } catch (Exception ex) {
            log.error("Error while calling AccessControl portal.", ex);
        }
        return null;
    }

    public static void main(String[] args) {
    }
}