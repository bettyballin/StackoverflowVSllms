import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// Define the BadRequestException class
class BadRequestException extends Exception {
    public BadRequestException(String message) {
        super(message);
    }
}

// Define the ErrorResponse class
class ErrorResponse {
    private String error;
    private String message;

    public ErrorResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }
}

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

    @Override
    public Response toResponse(BadRequestException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                       .entity(new ErrorResponse("Bad Request", e.getMessage()))
                       .header("error-code", "BAD_DATE_FORMAT")
                       .build();
    }

    public static void main(String[] args) {
        // Test code can be added here if necessary
    }
}