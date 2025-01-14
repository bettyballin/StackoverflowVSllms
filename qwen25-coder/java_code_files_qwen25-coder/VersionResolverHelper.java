import java.lang.String;

public class VersionResolverHelper {
    String requestedVersion;

    public VersionResolverHelper(Request request) {
        requestedVersion = getRequestedVersionFromHeader(request);
        if (requestedVersion == null || requestedVersion.isEmpty()) {
            requestedVersion = getRequestedVersionFromRequestParam(request);
        }
        if (requestedVersion == null || requestedVersion.isEmpty()) {
            // Default to the latest stable version if none specified
            requestedVersion = "v3";  // Assuming v3 is the latest stable version
        }
    }

    private String getRequestedVersionFromHeader(Request request) {
        // Placeholder implementation
        return null;
    }

    private String getRequestedVersionFromRequestParam(Request request) {
        // Placeholder implementation
        return null;
    }

    public static void main(String[] args) {
        Request request = new Request();
        VersionResolverHelper resolver = new VersionResolverHelper(request);
        // Use resolver.requestedVersion as needed
    }
}

class Request {
    // Placeholder for request properties
}