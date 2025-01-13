import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .header("Error", "Internal Server Error")
                .entity("An unexpected error occurred: " + e.getMessage())
                .build();
    }

    public static void main(String[] args) {
    }
}