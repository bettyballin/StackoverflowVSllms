import java.lang.String;
import java.io.IOException;

interface MessageConnection {
    public Object getAddress();
    public void close() throws IOException;
}

class Connector {
    public static Object open(String name) {
        return new MessageConnectionImpl();
    }
}

class MessageConnectionImpl implements MessageConnection {
    public Object getAddress() {
        return new SMSAddress("SMS://1234567890");
    }
    public void close() throws IOException {
        // do nothing
    }
}

class SMSAddress {
    private String address;
    public SMSAddress(String addr) {
        this.address = addr;
    }
    public String toString() {
        return this.address;
    }
}

public class MessageConnectororSmsConnectionManagerwouldbesuitableclassnamesforthisJavacode {

    MessageConnection mc = null;

    {
        try {
            mc  = (MessageConnection) Connector.open("sms://");
            String address = ((SMSAddress)mc.getAddress()).toString(); // returns device ID in the format "SMS://<address>" e.g., SMS://1234567890
            System.out.println("Address: " + address);
        } catch (Exception ex){
            ex.printStackTrace();
        } finally{
            if( mc != null ) {
                try {
                    mc.close();
                } catch(IOException ignore) { }
            }
        }
    }

    public static void main(String[] args) {
        new MessageConnectororSmsConnectionManagerwouldbesuitableclassnamesforthisJavacode();
    }

}