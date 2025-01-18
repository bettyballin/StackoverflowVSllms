import java.util.List;

public class ContactDataService extends RemoteService implements ContactService {
    // Other methods here...

    @Override
    public List<ContactData> getCandidateSummaryById(long id) throws Exception {
        try {
            // your logic here;
            return null;
        } catch (Exception ex) {
            InvocationException ie = new InvocationException();
            ie.setHttpStatusCode(HTTPResponses.FORBIDDEN); // Set HTTP error code
            throw new BadRequestException("Customized Message", ex, ie);
        }
    }
}

class RemoteService {
    // Base service methods (if any)
}

interface ContactService {
    List<ContactData> getCandidateSummaryById(long id) throws Exception;
    // Other method signatures...
}

class InvocationException extends Exception {
    private int httpStatusCode;

    public void setHttpStatusCode(int code) {
        this.httpStatusCode = code;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }
}

class BadRequestException extends Exception {
    public BadRequestException(String message, Throwable cause, InvocationException ie) {
        super(message, cause);
        // Additional processing with InvocationException if needed
    }
}

class HTTPResponses {
    public static final int FORBIDDEN = 403;
    // Other HTTP response codes...
}

class ContactData {
    // Fields and methods representing contact data
}