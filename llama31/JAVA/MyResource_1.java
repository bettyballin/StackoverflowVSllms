import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/myresource")
public class MyResource_1_1 {
  
  @DELETE
  public Response delete() {
    // move to recycle bin
    return Response.ok().build();
  }
  
  @DELETE
  @Path("/force")
  public Response deleteForced() {
    // force delete
    return Response.ok().build();
  }

	public static void main(String[] args) {
	}
}