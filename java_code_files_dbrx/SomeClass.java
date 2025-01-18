import javax.servlet.ServletContext;
import java.util.Set;
import java.util.HashSet;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class SomeClass {
    public Set<String> getDefinedRoles(ServletContext context) throws Exception {
        InputStream input = context.getResourceAsStream("/WEB-INF/web.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(input);
        Set<String> rolesSet = new HashSet<>();
        // TODO: Extract the role names from 'document' and add them to 'rolesSet'
        return rolesSet;
    }
}