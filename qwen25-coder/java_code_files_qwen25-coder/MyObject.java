import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@XmlRootElement(name = "objects")
class MyObject {
    @XmlAnyElement(lax = true)
    protected List<MyChildObject> childObjects = new ArrayList<>();

    public List<MyChildObject> getChildObjects() {
        return childObjects;
    }

    public void setChildObjects(List<MyChildObject> childObjects) {
        this.childObjects = childObjects;
    }
}

@XmlRootElement
class MyChildObject {
    protected String data1;
    protected String data2;
    protected String data3;

    @XmlElement(name = "data1")
    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    @XmlElement(name = "data2")
    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    @XmlElement(name = "data3")
    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }
}

public class JAXBExample {
    public static void main(String[] args) throws Exception {
        String xml = "<objects><dog><data1>1</data1><data2>2</data2><data3>3</data3></dog>"
                     + "<cat><data1>a</data1><data2>b</data2><data3>c</data3></cat></objects>";
        JAXBContext context = JAXBContext.newInstance(MyObject.class, MyChildObject.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        MyObject myObject = (MyObject) unmarshaller.unmarshal(new StringReader(xml));

        for (MyChildObject child : myObject.getChildObjects()) {
            System.out.println(child.getData1() + ", " + child.getData2() + ", " + child.getData3());
        }
    }
}