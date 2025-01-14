import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HelloWorldResource_3 extends ServerResource {

    @Get
    public String represent() {
        return "Hello, World!";
    }

    public static void main(String[] args) {
    }
}