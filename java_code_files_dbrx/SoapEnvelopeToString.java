import javax.xml.namespace.QName;

public class SoapEnvelopeToString extends BasicHandler {
    @Override
    public void invoke(MessageContext msgContext) throws AxisFault {
        try {
            QName name = new QName("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
            String soapString = msgContext.getRequestMessage().getSOAPPartAsString();
            System.out.println(soapString);
        } catch (Exception e) {
            throw AxisFault.makeFault(e);
        }
    }

    public static void main(String[] args) {
        // For testing purposes
        SoapEnvelopeToString instance = new SoapEnvelopeToString();
        try {
            instance.invoke(new MessageContext());
        } catch (AxisFault e) {
            e.printStackTrace();
        }
    }
}

// Stub implementations to make the code compile
class BasicHandler {
    public void invoke(MessageContext msgContext) throws AxisFault {
        // Base implementation (empty)
    }
}

class MessageContext {
    public SOAPMessage getRequestMessage() {
        return new SOAPMessage();
    }
}

class SOAPMessage {
    public String getSOAPPartAsString() {
        return "<SOAP Message Content>";
    }
}

class AxisFault extends Exception {
    public AxisFault(String message) {
        super(message);
    }

    public static AxisFault makeFault(Exception e) {
        return new AxisFault(e.getMessage());
    }
}