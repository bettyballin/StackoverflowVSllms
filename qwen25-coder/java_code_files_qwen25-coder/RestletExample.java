import org.restlet.Client;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Form;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.data.Reference;
import org.restlet.representation.Representation;

public class RestletExample {
    public static void main(String[] args) throws Exception {
        // Define the URL and parameters
        Reference baseRef = new Reference("https://www.awebsite.com/login");
        Form form = new Form();
        form.add("username", "user123");  // Add your login credentials here
        form.add("password", "securePass!23");

        // Choose the method (GET or POST)
        Method method = Method.POST;  // Change to Method.GET for GET request

        Request request = new Request(method, baseRef);
        
        if (method == Method.GET) {
            // For a GET request, add query parameters directly to the reference
            baseRef.setQuery(form.getQueryString());
            request.setResourceRef(baseRef);
        } else {
            // For a POST request, attach the form as the entity body
            Representation formRep = form.getWebRepresentation();
            request.setEntity(formRep);
        }

        Client client = new Client(Protocol.HTTPS);
        Response response = client.handle(request);

        if (response.getStatus().isSuccess()) {
            response.getEntity().write(System.out);
        } else {
            System.err.println("Request failed with status: " + response.getStatus());
        }
    }
}