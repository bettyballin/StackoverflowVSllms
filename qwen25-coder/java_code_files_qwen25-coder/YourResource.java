import java.lang.String;

@interface Path {
    String value();
}

@interface GET {
}

@interface Produces {
    String value();
}

class MediaType {
    public static final String APPLICATION_JSON = "application/json";
}

class YourManagedBean {
    public String getString() {
        return "some string";
    }
}

@Path("/yourPath")
public class YourResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getStringFromBean() {
        // Call your managed bean or perform necessary logic to get the string
        return new YourManagedBean().getString();
    }

    public static void main(String[] args) {
    }
}