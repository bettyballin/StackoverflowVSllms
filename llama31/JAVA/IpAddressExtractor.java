import java.lang.String;

public class IpAddressExtractor {
    public static void main(String[] args) {
        // Create a new instance of the class to access non-static fields
        IpAddressExtractor extractor = new IpAddressExtractor();
        // Note: 'request' is not defined in the original code, 
        // so I assume it's a field that should be passed or initialized somehow.
        // For demonstration purposes, let's assume it's an HttpServletRequest.
        // HttpServletRequest request = ...; // You need to obtain or create this

        // Since 'request' is not defined and ClientIPRequestWrapper is not a standard Java class,
        // let's comment out these lines to make the code compile.
        // ClientIPRequestWrapper wrappedRequest = new ClientIPRequestWrapper(request);
        // String ipAddress = wrappedRequest.getRemoteAddr();
    }
}