import java.lang.String;
import org.apache.cxf.tools.validator.WSDLValidator;

public class WSDLValidationExample {
    public static void main(String[] args) {
        String wsdlLocation = "path/to/wsdl/file.wsdl";
        WSDLValidator validator = new WSDLValidator();
        validator.validate(wsdlLocation);
    }
}