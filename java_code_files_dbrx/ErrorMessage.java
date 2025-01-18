import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "error") // Let's call the root element "error" in XML / JSON response
public class ErrorMessage {
    private final int statusCode;
    private final String errorMsg;

    public ErrorMessage(int statusCode, String errorMsg) {
        this.statusCode = statusCode;
        this.errorMsg = errorMsg;
    }

    public int getStatusCode() { return this.statusCode; }

    public String getErrorMsg()  { return this.errorMsg; }
}