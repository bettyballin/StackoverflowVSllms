import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

@Provider // Indicate it's a provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable ex) {
        int statusCode = 500; // Internal Server Error as fallback

        if (ex instanceof IllegalArgumentException ||
            (ex.getCause() != null && ex.getCause().getClass().equals(IllegalArgumentException.class))) {
            statusCode = Response.Status.BAD_REQUEST.getStatusCode(); // 400 Bad Request for this case
        }
        // else if ( /* some other specific exceptions handling */ ) {
        //     ...
        // }

        ErrorMessage errorMsg = new ErrorMessage(statusCode, ex.getMessage());

        return Response.status(statusCode)
                .type(MediaType.APPLICATION_JSON) // assuming the response will be in JSON format
                .entity(errorMsg)
                .build(); // Create a JAX-RS Response instance and pass it into ErrorMessage bean object serialized to JSON
    }
}

@XmlRootElement
class ErrorMessage {
    private int statusCode;
    private String message;

    public ErrorMessage() {
        // Default constructor
    }

    public ErrorMessage(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    // Getters and setters
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}