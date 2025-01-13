/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class XMLValidator {
    public boolean validateXML(InputStream inputStream) {
        try {
            InputStream inputStream2 = this.getClass().getResourceAsStream("/path/to/config.xsd");
            if (inputStream2 == null) {
                throw new RuntimeException("Could not find schema resource");
            }
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = schemaFactory.newSchema(new StreamSource(inputStream2));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(inputStream));
            return true;
        }
        catch (Exception exception) {
            System.err.println("XML is invalid: " + exception.getMessage());
            return false;
        }
    }

    public static void main(String[] stringArray) {
        XMLValidator xMLValidator = new XMLValidator();
        InputStream inputStream = xMLValidator.getClass().getResourceAsStream("/path/to/example.xml");
        boolean bl = xMLValidator.validateXML(inputStream);
        System.out.println("Is XML valid? " + bl);
    }
}
