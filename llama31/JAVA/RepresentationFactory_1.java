import java.lang.String;
import javax.ws.rs.core.MediaType;

class StringRepresentation extends Representation {
    public StringRepresentation(String jsonData, MediaType mediaType, String charset) {
        // Implementation of the constructor
    }
}

class Representation {
    // Implementation of the Representation class
}

public class RepresentationFactory_1_1 {
    Representation representation = new StringRepresentation("jsonData", MediaType.APPLICATION_JSON, "ISO-8859-1");

    public static void main(String[] args) {
    }
}