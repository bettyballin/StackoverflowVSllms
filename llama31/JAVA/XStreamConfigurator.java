import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.collections.CustomCollectionConverter;

public class XStreamConfigurator {
    XStream xstream = new XStream();

    public XStreamConfigurator() {
        xstream.registerConverter(new CustomCollectionConverter());
    }

    public static void main(String[] args) {
        new XStreamConfigurator();
    }
}