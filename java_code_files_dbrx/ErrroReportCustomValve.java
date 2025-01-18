import java.io.IOException;
import javax.servlet.ServletException;

import org.apache.catalina.ValveBase;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;

public class ErrroReportCustomValve extends ValveBase {

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        // You can try-catch here for any exception that you expect to process.
        // This way only exceptions that are thrown and caught here will be sent to your custom error page
        // with the URL information attached as a request attribute or parameter
        Request wrappedRequest = new RequestWrapper(request);
        getNext().invoke(wrappedRequest, response);  // Invoke the next Valve in the pipeline
    }

    @Override
    public String getInfo() {
        return "ErrroReportCustomValve";
    }
}

class RequestWrapper extends Request {
    private Request originalRequest;

    public RequestWrapper(Request request) {
        super(request.getConnector());
        this.originalRequest = request;
    }

    // Override methods as necessary to customize the request handling
}