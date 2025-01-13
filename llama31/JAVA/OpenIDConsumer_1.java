import org.openid4java.consumer.ConsumerManager;
import org.openid4java.consumer.VerificationResult;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.discovery.Identifier;

public class OpenIDConsumer_1 {
    public static void main(String[] args) throws Exception {
        // Create a consumer manager
        ConsumerManager manager = new ConsumerManager();

        // Create a discovery information object
        DiscoveryInformation discovered = manager.associate(new Identifier("https://example.com/openid"));
    }
}