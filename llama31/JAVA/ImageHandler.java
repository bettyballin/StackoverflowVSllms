import java.lang.String;
import java.lang.Integer;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

class Image {
    private byte[] data;
    private Date lastModified;

    public Image(byte[] data, Date lastModified) {
        this.data = data;
        this.lastModified = lastModified;
    }

    public byte[] getData() {
        return data;
    }

    public Date getLastModified() {
        return lastModified;
    }
}

class Request {
    private String pathParameter;
    private String header;

    public String getPathParameter(String key) {
        // Simplified implementation
        return pathParameter;
    }

    public String getHeader(String key) {
        // Simplified implementation
        return header;
    }
}

public class ImageHandler {
    public Response handleRequest(Request request) {
        int id = Integer.parseInt(request.getPathParameter("id"));
        Image image = getImageFromDatabase(id);
        if (image == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        String eTag = String.valueOf(image.getLastModified().getTime());
        if (request.getHeader("If-None-Match") != null && request.getHeader("If-None-Match").equals(eTag)) {
            return Response.status(Status.NOT_MODIFIED).build();
        }

        ResponseBuilder response = Response.ok(image.getData());
        response.header("ETag", eTag);
        response.header("Cache-Control", "max-age=31536000"); // 1 year
        response.header("Last-Modified", image.getLastModified().toString());
        return response.build();
    }

    private Image getImageFromDatabase(int id) {
        // retrieve image from database
        // Simplified implementation
        byte[] data = {1, 2, 3};
        ZonedDateTime zdt = LocalDateTime.now().atZone(ZoneId.systemDefault());
        Date date = Date.from(zdt.toInstant());
        return new Image(data, date);
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.pathParameter = "123";
        ImageHandler handler = new ImageHandler();
        Response response = handler.handleRequest(request);
        System.out.println(response.getStatus());
    }
}