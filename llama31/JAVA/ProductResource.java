import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/products")
public class ProductResource {
    @Path("/by-{sort}")
    @GET
    public Response getProductsBySort(@PathParam("sort") String sort, @QueryParam("page") int page) {
        // retrieve products based on sort and page
        List<Product> products = productService.getProductsBySort(sort, page);
        return Response.ok(products).build();
    }

    public static void main(String[] args) {
    }
}