public class ImageServer {

    public Response serveImage(int id) {
        ImageData imageData = getImageFromDatabase(id);
        
        String etag = imageData.getETag();
        long lastModified = imageData.getLastModifiedTime();

        // Check ETag or If-Modified-Since
        if (requestMatchesEtag(etag) || requestNotModifiedSince(lastModified)) {
            return new Response(304, "Not Modified");
        }

        byte[] imageBytes = fetchImageFromDatabaseOrCache(imageData);
        Response response = new Response(200, "OK");
        response.setHeader("Content-Type", "image/jpeg"); // adjust content-type as necessary
        response.setHeader("ETag", etag);
        response.setHeader("Last-Modified", formatDate(lastModified));
        response.setBody(imageBytes);

        return response;
    }
    
    private ImageData getImageFromDatabase(int id) {
        // placeholder implementation
        return new ImageData();
    }
    
    private boolean requestMatchesEtag(String etag) {
        // placeholder implementation
        return false;
    }
    
    private boolean requestNotModifiedSince(long lastModified) {
        // placeholder implementation
        return false;
    }
    
    private byte[] fetchImageFromDatabaseOrCache(ImageData imageData) {
        // placeholder implementation
        return new byte[0];
    }
    
    private String formatDate(long timestamp) {
        // placeholder implementation
        return "";
    }
    
    public static void main(String[] args) {
    }
    
    // Inner class definitions
    class Response {
        private int statusCode;
        private String statusMessage;
        public Response(int code, String message) {
            this.statusCode = code;
            this.statusMessage = message;
        }
        public void setHeader(String name, String value) {
            // placeholder implementation
        }
        public void setBody(byte[] body) {
            // placeholder implementation
        }
    }
    
    class ImageData {
        public String getETag() {
            // placeholder implementation
            return "";
        }
        public long getLastModifiedTime() {
            // placeholder implementation
            return 0L;
        }
    }
}