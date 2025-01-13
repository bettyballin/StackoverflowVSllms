import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.lang.String;

@Provider
public class ParseExceptionMapper implements ExceptionMapper<ParseException> {

    @Override
    public Response toResponse(ParseException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .header("Error", "Invalid date format")
                .entity("Invalid date format: " + e.getMessage())
                .build();
    }

    public static void main(String[] args) {
    }
}