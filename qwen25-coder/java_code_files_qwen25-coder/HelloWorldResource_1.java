import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.BadRequestException;

@Path("/hello")
public class HelloWorldResource_1 {

    @GET
    @Produces("text/html")
    public String get(
        @QueryParam("name") String name,
        @QueryParam("birthDate") String birthDateString) {

        try {
            // Attempt to parse the date string
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            Date birthDate = format.parse(birthDateString);
            return "Hello, " + name + "! You were born on " + birthDate.toString() + ".";
        } catch (ParseException e) {
            throw new BadRequestException("Invalid date format: " + birthDateString);
        }
    }

    public static void main(String[] args) {
    }
}