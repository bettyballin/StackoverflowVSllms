import java.lang.String;
public class AdapterFactory_1 {

    public interface RequestAdapter {
        public AbstractRequest adapt(String rawMessage);
    }

    public interface ResponseAdapter {
        public void send(AbstractResponse response, String address);
    }

    public static void main(String[] args) {
    }
}

interface AbstractRequest {}
interface AbstractResponse {}