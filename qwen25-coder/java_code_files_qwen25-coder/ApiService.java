import java.lang.String;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class ApiService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String executeStoredProcedure() {
        // Logic to call Stored Procedure and return result (simplified for example)
        return "{\"result\": \"Hello from the stored procedure!\"}";
    }

    public static void main(String[] args) {
    }
}