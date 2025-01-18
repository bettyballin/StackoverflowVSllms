import org.restlet.Client;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Form;
import org.restlet.data.Method;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.representation.FormRepresentation;

public class LoginRequestSender {
    public static void main(String[] args) {
        Form form = new Form();
        form.add("username", "my_user"); // set your username
        form.add("password", "my_pass"); // set your password
        Request request = new Request(Method.POST, "https://www.awebsite.com/login");
        request.setEntity(new FormRepresentation(MediaType.APPLICATION_WWW_FORM, form));
        Client client = new Client(Protocol.HTTPS);
        Response response = client.handle(request);
        System.out.println("" + response.getEntity().getText());
    }
}