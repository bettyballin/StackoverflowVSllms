import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/system")
public class SystemResource {

    private static final String LOG_FILE = "/apps/glassfish5/domains/domain1/logs/server.log"; // Replace with the actual path on your system or make it configurable in application properties

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getLatestLogEntries() {

        try (Stream<String> lines = Files.lines(Paths.get(LOG_FILE))
                .skip(Math.max(0, Files.readAllLines(Paths.get(LOG_FILE)).size() - 5))) // Change this to get required number of lines or use tailer API as suggested
        {
            return Response.ok().entity(lines.collect(Collectors.toList()))
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
        } catch (NoSuchFileException ex) {
            return Response  // Custom exception message format for missing log file
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Required resource not found: " + LOG_FILE)
                .build();
        } catch (IOException e) {
            return Response // Custom exception message format for generic error
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to read log entries from " + LOG_FILE)
                    .build();
        }
    }

    public static void main(String[] args) {
    }
}