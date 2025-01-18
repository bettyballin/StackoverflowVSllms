import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

// In Axis, mark array properties with @XmlElementWrapper(name = "ArrayOf<Type>"). For example:
@XmlRootElement
public class MyServiceResponse {
    // ... other members ...
    @XmlElement(name="long")
    @XmlElementWrapper(name="ArrayOfLong")
    private long[] myLongArray;

    public static void main(String[] args) {
    }
}