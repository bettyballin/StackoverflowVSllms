// Server side service implementation

class RemoteServiceServlet {
    // Empty class
}

interface MyClientSideService {
    String refreshParams(String count);
}

public class MyServerSideServiceImpl extends RemoteServiceServlet implements MyClientSideService {

    // interface method implementations
     public String refreshParams(String count) {
         System.out.println("Refresh Count " + count);  // print out the value sent across for debugging
         // Do something here with this refreshCount...
         return null;   // nothing to send back, so just return null (or you can modify your interface methods and AsyncCallback class accordingly)
    }

    public static void main(String[] args) {
    }
}