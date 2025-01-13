import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "User")
class User {
    private String name;
    private String email;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class Main_250_250 {
    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(User.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        String flexXml = "<User><name>John</name><email>john@example.com</email></User>";
        User user = (User) unmarshaller.unmarshal(new StringReader(flexXml));
        System.out.println(user.getName()); // prints "John"
        System.out.println(user.getEmail()); // prints "john@example.com"
    }
}