import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "urn:my:ns1")
public class SomeRootElement {
    @XmlElement(namespace = "urn:my:ns1")
    private SomeElement someElement;

    @XmlElement(namespace = "urn:my:ns2", name = "someElement")
    private ASomeElement aSomeElement;

    @XmlElement(namespace = "urn:my:ns3", name = "someElement")
    private BSomeElement bSomeElement;

    // getters and setters

    public static void main(String[] args) {
        // Example of creating an instance of this class
        SomeRootElement root = new SomeRootElement();
        root.someElement = new SomeElement();
        root.aSomeElement = new ASomeElement();
        root.bSomeElement = new BSomeElement();
        // Further initialization and usage...
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "urn:my:ns1")
class SomeElement {
    // properties and methods
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "urn:my:ns2")
class ASomeElement {
    // properties and methods
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "urn:my:ns3")
class BSomeElement {
    // properties and methods

    // This main method is redundant if you're using the main in SomeRootElement
    // public static void main(String[] args) {
    // }
}