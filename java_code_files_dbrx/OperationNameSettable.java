import java.lang.String;
import javax.xml.namespace.QName;

public class OperationNameSettable {
    static class Call {
        void setOperationName(QName qname) {
            // Implementation here
        }
    }
    static Call call = new Call();
    
    static {
        call.setOperationName(new QName("http://testPackage.fc.com/", "doBasicStuff"));
    }

    public static void main(String[] args) {
    }
}