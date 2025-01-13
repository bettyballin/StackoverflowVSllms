import java.lang.String;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.DomHandler;

public class MyObject_4_4 {
    protected String otherData;

    @XmlAnyElement(MyChildObjectDomHandler.class)
    @XmlElementWrapper(name = "objects")
    protected List<MyChildObject> childObjects;
}

@XmlRootElement
class MyChildObject {
    public String data1;
    public String data2;
    public String data3;
}

class MyChildObjectDomHandler implements DomHandler<MyChildObject, Node> {
    @Override
    public MyChildObject createUnmarshaller(ValidationEventHandler errorHandler) {
        return new MyChildObject();
    }

    @Override
    public Node getElement(Node node) {
        return node;
    }

    @Override
    public MyChildObject merge(MyChildObject target, Node node) {
        // Convert the Node to a MyChildObject instance
        MyChildObject myChildObject = new MyChildObject();
        myChildObject.data1 = node.getAttributes().getNamedItem("data1").getNodeValue();
        myChildObject.data2 = node.getAttributes().getNamedItem("data2").getNodeValue();
        myChildObject.data3 = node.getAttributes().getNamedItem("data3").getNodeValue();
        return myChildObject;
    }
}

class Main {
    public static void main(String[] args) {
    }
}