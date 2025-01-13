import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// Assume you have a Fuego Object named "MyBusinessObject"
// with a method "getSuggestions" that returns a list of strings

@Path("/autocomplete")
public class AutocompleteResource {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getSuggestions(@QueryParam("input") String input) {
    MyBusinessObject obj = new MyBusinessObject();
    List<String> suggestions = obj.getSuggestions(input);
    return Response.ok(suggestions).build();
  }

  public static void main(String[] args) {
  }
}