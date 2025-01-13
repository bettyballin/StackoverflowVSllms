import java.lang.String;

public class RepresentationFactory {
    Representation representation;

    public RepresentationFactory(String jsonData) {
        representation = new StringRepresentation(jsonData, MediaType.TEXT_PLAIN);
    }

    public static void main(String[] args) {
    }
}

class StringRepresentation implements Representation {
    private String jsonData;
    private MediaType mediaType;

    public StringRepresentation(String jsonData, MediaType mediaType) {
        this.jsonData = jsonData;
        this.mediaType = mediaType;
    }
}

enum MediaType {
    TEXT_PLAIN
}

interface Representation {}