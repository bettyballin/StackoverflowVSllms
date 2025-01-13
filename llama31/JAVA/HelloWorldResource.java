import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, World!";
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public String sayHelloXml() {
        return "<hello>World!</hello>";
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHelloJson() {
        return "{\"hello\": \"World!\"}";
    }

    public static void main(String[] args) {
        HelloWorldResource helloWorld = new HelloWorldResource();
        System.out.println(helloWorld.sayHello());
        System.out.println(helloWorld.sayHelloXml());
        System.out.println(helloWorld.sayHelloJson());
    }
}