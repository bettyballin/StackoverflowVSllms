import java.lang.String;

// Define a simple Request class
class Request {
    private String header;
    private String parameter;

    public Request(String header, String parameter) {
        this.header = header;
        this.parameter = parameter;
    }

    public String getHeader(String key) {
        if (key.equals("X-API-Version")) {
            return header;
        }
        return null;
    }

    public String getParameter(String key) {
        if (key.equals("version")) {
            return parameter;
        }
        return null;
    }
}

public class ApiVersionResolver {
    public static void main(String[] args) {
        // Create an instance of Request
        Request request = new Request("v2", null);

        String version = request.getHeader("X-API-Version") != null ? request.getHeader("X-API-Version") : request.getParameter("version");
        if (version == null) {
            version = "v1"; // default to oldest version
        }
        System.out.println("Version: " + version);
    }
}