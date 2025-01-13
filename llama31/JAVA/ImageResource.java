import java.lang.String;
import java.lang.List;
import java.util.Collections;
import java.util.List;
import java.security.SecureRandom;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/images")
public class ImageResource {
    private ImageService imageService;

    @GET
    @Produces("application/json")
    public Response getImages(@QueryParam("tags") List<String> tags, @QueryParam("random") boolean random) {
        List<Image> images = imageService.getImagesByTags(tags);
        if (random) {
            // Use a CSPRNG to shuffle the results
            SecureRandom randomizer = new SecureRandom();
            Collections.shuffle(images, randomizer);
            // Return a limited number of random images, e.g. 10
            images = images.subList(0, Math.min(10, images.size()));
        }
        return Response.ok(images).build();
    }

    public static void main(String[] args) {
    }
}

class Image {
    // Image object definition is missing in the original code
}

class ImageService {
    // ImageService class definition is missing in the original code
    public List<Image> getImagesByTags(List<String> tags) {
        // Implementation is missing in the original code
        return null;
    }
}