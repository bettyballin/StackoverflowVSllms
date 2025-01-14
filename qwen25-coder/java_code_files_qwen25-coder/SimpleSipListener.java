import javax.sip.*;
import javax.sip.address.AddressFactory;
import javax.sip.address.SipURI;
import javax.sip.header.HeaderFactory;
import javax.sip.message.MessageFactory;
import javax.sip.address.Address;
import javax.sip.header.*;
import javax.sip.message.*;
import javax.sip.address.URI;
import java.util.Properties;
import java.util.TooManyListenersException;

public class SimpleSipListener implements SipListener {
    private SipFactory sipFactory;
    private SipStack sipStack;

    public void init() throws PeerUnavailableException, InvalidArgumentException {
        this.sipFactory = SipFactory.getInstance();
        this.sipFactory.setPathName("gov.nist");
        Properties properties = new Properties();
        properties.setProperty("javax.sip.STACK_NAME", "stack1");

        // Create a SIP Stack
        sipStack = sipFactory.createSipStack(properties);
    }

    @Override
    public void processRequest(RequestEvent requestEvent) {
        System.out.println("Received Request: " + requestEvent.getRequest());
    }

    @Override
    public void processResponse(ResponseEvent responseEvent) {
        System.out.println("Received Response: " + responseEvent.getResponse());
    }

    @Override
    public void processTimeout(TimeoutEvent timeoutEvent) {
        // Handle timeout events if necessary
    }

    @Override
    public void processIOException(IOExceptionEvent exceptionEvent) {
        // Handle IO exceptions if necessary
    }

    @Override
    public void processTransactionTerminated(TransactionTerminatedEvent transactionTerminatedEvent) {
        System.out.println("Transaction Terminated: " + transactionTerminatedEvent.getClientTransaction());
    }

    @Override
    public void processDialogTerminated(DialogTerminatedEvent dialogTerminatedEvent) {
        // Handle dialog termination if necessary
    }

    public static void main(String[] args) {
        SimpleSipListener listener = new SimpleSipListener();
        try {
            listener.init();
        } catch (PeerUnavailableException | InvalidArgumentException e) {
            e.printStackTrace();
        }
    }
}