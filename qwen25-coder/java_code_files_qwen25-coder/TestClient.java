import javax.xml.namespace.QName;
import java.net.URL;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class TestClient {

    public static void main(String[] args) {
        try {
            String endpoint = "http://localhost:8080/TestWebService/services/DoesMagic";  

            Service service = new Service();
            Call call = (Call) service.createCall();

            call.setTargetEndpointAddress(new URL(endpoint));
            // Corrected the QName parameters
            call.setOperationName(new QName("http://testPackage.fc.com/", "doBasicStuff"));

            String ret = (String) call.invoke(new Object[]{"some kind of message"});

            System.out.println(ret);

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}