import javax.sip.*;
import javax.sip.address.*;
import javax.sip.header.*;
import javax.sip.message.*;

public class SipClient {
    public static void main(String[] args) throws Exception {
        // Create a SIP factory
        SipFactory sipFactory = SipFactory.getInstance();
        sipFactory.setPathName("gov.nist");

        // Create a SIP address
        AddressFactory addressFactory = sipFactory.createAddressFactory();
        URI uri = addressFactory.createURI("sip:user@domain.com");
        Address sipAddress = addressFactory.createAddress(uri);

        // Create a SIP provider
        SipProvider sipProvider = sipFactory.createSipProvider(sipFactory.createListeningPoint("localhost", 5060, "udp"));

        // Create an INVITE request
        MessageFactory messageFactory = sipFactory.createMessageFactory();
        Request inviteRequest = messageFactory.createRequest(Request.INVITE, sipAddress.getURI());
        inviteRequest.setTo(sipAddress);
        inviteRequest.setFrom(sipAddress);
        inviteRequest.addHeader(new ContactHeader(sipAddress));
        sipProvider.sendRequest(inviteRequest);
    }
}