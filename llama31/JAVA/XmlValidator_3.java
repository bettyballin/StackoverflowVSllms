import javax.ws.rs.core.Response;

public enum ValidationResult {
    VALID(200, "XML is valid"),
    INVALID_XML(400, "Invalid XML input"),
    INVALID_SCHEMA(422, "XML is invalid against schema"),
    SCHEMA_NOT_FOUND(404, "Schema file not found"),
    INTERNAL_ERROR(500, "Internal server error");

    private final int statusCode;
    private final String message;

    ValidationResult(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}

public class XmlValidator_3 {
    // In your validation server
    public Response validateXml(String xml, String schema) {
        try {
            // Validate XML against schema
            // ...
            if (/* validation fails */) {
                return Response.status(ValidationResult.INVALID_SCHEMA.getStatusCode())
                        .entity(ValidationResult.INVALID_SCHEMA.getMessage())
                        .build();
            } else if (/* schema not found */) {
                return Response.status(ValidationResult.SCHEMA_NOT_FOUND.getStatusCode())
                        .entity(ValidationResult.SCHEMA_NOT_FOUND.getMessage())
                        .build();
            } else if (/* internal error */) {
                return Response.status(ValidationResult.INTERNAL_ERROR.getStatusCode())
                        .entity(ValidationResult.INTERNAL_ERROR.getMessage())
                        .build();
            } else {
                return Response.ok(ValidationResult.VALID.getMessage()).build();
            }
        } catch (Exception e) {
            return Response.status(ValidationResult.INTERNAL_ERROR.getStatusCode())
                    .entity(ValidationResult.INTERNAL_ERROR.getMessage())
                    .build();
        }
    }

    public static void main(String[] args) {
        XmlValidator validator = new XmlValidator();
        Response response = validator.validateXml("example.xml", "example.xsd");
        System.out.println(response.getStatus() + " " + response.getEntity());
    }
}