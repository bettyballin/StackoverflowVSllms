// Amazon Connect IVR example in Java
import software.amazon.awssdk.services.connect.ConnectClient;
import software.amazon.awssdk.services.connect.model.*;

public class AmazonConnectIVRExample {
    public static void main(String[] args) {
        // Create a Connect client
        ConnectClient connectClient = ConnectClient.create();

        // Create a request for starting an outbound voice contact
        StartOutboundVoiceContactRequest request = StartOutboundVoiceContactRequest.builder()
                .contactFlowId("your-contact-flow-id")
                .instanceId("your-instance-id")
                .sourcePhoneNumber("your-source-phone-number")
                .destinationPhoneNumber("caller-phone-number")
                .build();

        // Start the outbound voice contact
        StartOutboundVoiceContactResponse response = connectClient.startOutboundVoiceContact(request);

        // Close the client to prevent resource leaks
        connectClient.close();
    }
}