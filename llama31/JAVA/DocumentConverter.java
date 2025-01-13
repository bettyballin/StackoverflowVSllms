import java.lang.String;
import com.adobe.idp.client.ServiceClientFactory;
import com.adobe.idp.client.ScClientException;
import com.adobe.idp.Document;
import com.adobe.idp.dsc.clientsdk.ServiceClientFactoryProperties;
import com.adobe.livecycle.convertpdfservice.client.ConvertPdfServiceClient;

public class DocumentConverter {
    public static void main(String[] args) {
        try {
            ServiceClientFactory factory = ServiceClientFactory.createInstance();
            factory.setProperty(ServiceClientFactoryProperties.DSC_TRANSACTION_TIMEOUT, 1800); // 30 minutes

            ConvertPdfServiceClient convertPDFClient = new ConvertPdfServiceClient(factory);
        } catch (ScClientException e) {
            e.printStackTrace();
        }
    }
}