import javax.xml.bind.annotation.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
@interface XmlNamespace {
    String prefix();
    String reference();
}

@XmlRootElement(name = "root", namespace = "urn:my:ns1")
public class Root {
    @XmlNamespace(prefix = "a", reference = "urn:my:ns2")
    public SomeClassA a;

    @XmlNamespace(prefix = "b", reference = "urn:my:ns3")
    public SomeClassB b;

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class SomeElement { // common element in different namespaces
        public String value;
    }

    @XmlRootElement(name = "someElement", namespace = "urn:my:ns2")
    @XmlNamespace(prefix = "a", reference = "urn:my:ns2")
    public static class SomeClassA extends SomeElement {}

    @XmlRootElement(name = "someElement", namespace = "urn:my:ns3")
    @XmlNamespace(prefix = "b", reference = "urn:my:ns3")
    public static class SomeClassB extends SomeElement {}

    public static void main(String[] args) {
    }
}