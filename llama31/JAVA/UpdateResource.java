import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ServerProperties;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

// Server-side (Java example using Jersey)
@Path("/updates")
public class UpdateResource extends ResourceConfig {

    public UpdateResource() {
        packages("jersey.sse.example");
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        register(this);
    }

    @GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput getUpdates() {
        EventOutput eventOutput = new EventOutput();
        // Send updates to connected clients
        new Thread(() -> {
            try {
                eventOutput.write(new OutboundEvent.Builder()
                    .data(String.class, "New content available!")
                    .build());
                eventOutput.close();
            } catch (Exception e) {
                Logger.getLogger(UpdateResource.class.getName()).log(Level.SEVERE, null, e);
            }
        }).start();
        return eventOutput;
    }

    public static void main(String[] args) {
        final URI baseUri = URI.create("http://localhost:8080/");
        ResourceConfig config = new UpdateResource();
        try {
            GrizzlyHttpServerFactory.createHttpServer(baseUri, config).start();
            System.out.println("Press Enter to stop the server...");
            System.in.read();
        } catch (Exception e) {
            Logger.getLogger(UpdateResource.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}