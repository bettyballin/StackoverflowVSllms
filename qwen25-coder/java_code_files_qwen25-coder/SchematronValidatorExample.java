import java.io.File;
import javax.xml.transform.stream.StreamSource;

import com.helger.schematron.ISchematronResource;
import com.helger.schematron.SchematronHelper;
import com.helger.schematron.SchematronOutputType;
import com.helger.schematron.xslt.SchematronResourceSCH;

public class SchematronValidatorExample {
    public static void main(String[] args) throws Exception {
        // Load the Schematron schema
        File schFile = new File("path/to/your/schema.sch");
        ISchematronResource schematronSchema = SchematronResourceSCH.fromFile(schFile);

        if (!schematronSchema.isValidSchematron())
            throw new IllegalArgumentException("Invalid Schematron schema!");

        // Load the XML document to be validated
        File xmlFile = new File("path/to/your/document.xml");

        // Validate the XML against the Schematron schema
        SchematronOutputType result = SchematronHelper.applySchematron(schematronSchema, new StreamSource(xmlFile));

        boolean isValid = SchematronHelper.getSchematronValidity(result).isValid();

        System.out.println("Is valid: " + isValid);
    }
}