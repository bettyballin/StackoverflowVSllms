import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBException;

public class Validator_2_2 {
    private Marshaller marshaller;

    public Validator_2(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public void validate(Object yourObject) {
        try {
            marshaller.validate(yourObject);
        } catch (JAXBException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create a marshaller instance
        // For simplicity, let's assume we have a JAXB context
        // In a real-world scenario, you would need to create a JAXB context and marshaller
        Marshaller marshaller = null; // Initialize marshaller properly in a real application

        Validator_2 validator = new Validator_2(marshaller);
        Object yourObject = null; // Initialize yourObject properly in a real application
        validator.validate(yourObject);
    }
}