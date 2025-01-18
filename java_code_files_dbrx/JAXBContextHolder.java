import java.lang.String;
import javax.xml.bind.JAXBContext;

public class JAXBContextHolder {
    JAXBContext jaxbContext = JAXBContext.newInstance(Root.class, SomeClassA.class, SomeClassB.class);
    // Now use this context for marshalling and unmarshal process

    public static void main(String[] args) {
    }
}

class Root {
    // Class definition
}

class SomeClassA {
    // Class definition
}

class SomeClassB {
    // Class definition
}