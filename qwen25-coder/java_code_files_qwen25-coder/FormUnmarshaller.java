import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

public class FormUnmarshaller {
    public static void main(String[] args) throws Exception {
        File file = new File("formDefinition.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Form.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Form form = (Form) unmarshaller.unmarshal(file);
        System.out.println(form.getName()); // prints: exampleForm
    }

    @XmlRootElement
    public static class Form {
        private String name;

        public String getName() {
            return name;
        }

        // Setter needed for JAXB unmarshalling
        public void setName(String name) {
            this.name = name;
        }
    }
}