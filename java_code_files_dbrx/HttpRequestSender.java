import org.restlet.Client;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;

public class HttpRequestSender {
    public static void main(String[] args) {
        // Create new representation for Parameters object
        Representation entity = new StringRepresentation("username=my_user&password=my_pass", MediaType.APPLICATION_WWW_FORM);
        Request request = new Request(Method.GET, "https://www.awebsite.com/login");
        request.setEntity(entity);
        // Create client and handle the request
        Client client = new Client(Protocol.HTTPS);
        Response response = client.handle(request);
        System.out.println("" + response.getEntity().getText());
    }
}