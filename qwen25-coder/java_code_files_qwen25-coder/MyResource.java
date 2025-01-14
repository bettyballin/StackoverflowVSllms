import java.lang.String;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class MyResource extends ServerResource {
    @Get("text/html")
    public String represent() {
        return "<html><body>"
                + "<h1>This is my first Restful web service.</h1>"
                + "</body></html>";
    }

    public static void main(String[] args) {
    }
}