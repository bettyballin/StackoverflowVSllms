import java.lang.String;
// using Spring WS for contract first approach

@Endpoint // Marks this class as a Web Service Endpoint
public class MyWebService {
  @PayloadRoot(localPart = "request", namespace = "http://myapp.com/ws")
  public void processRequest(@RequestPayload Request request) {
    // ...
  }

  public static void main(String[] args) {
  }
}

// Annotation stubs
@interface Endpoint {}

@interface PayloadRoot {
    String localPart();
    String namespace();
}

@interface RequestPayload {}

// Minimal Request class
class Request {
  // empty body
}