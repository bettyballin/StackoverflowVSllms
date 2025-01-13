import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.WebApplicationException;

@Path("/hello")
public class HelloWorldResource_1_1 {

    @GET
    @Produces("text/html")
    public String get(
        @QueryParam("name") String name,
        @QueryParam("birthDate") String birthDateStr) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date birthDate = format.parse(birthDateStr);
            // ...
        } catch (ParseException e) {
            throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
                    .header("Error", "Invalid date format")
                    .entity("Invalid date format: " + e.getMessage())
                    .build());
        }
    }

	public static void main(String[] args) {
	}
}