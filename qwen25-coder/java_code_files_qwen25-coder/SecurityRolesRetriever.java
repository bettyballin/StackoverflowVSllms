import java.util.Set;
import java.util.HashSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class SecurityRolesRetriever {

    public static Set<String> getSecurityRoles(ServletContext servletContext) throws Exception {
        String webXmlPath = servletContext.getRealPath("/WEB-INF/web.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(webXmlPath);
        
        // Optional, but recommended
        doc.getDocumentElement().normalize();

        NodeList securityRoleElements = doc.getElementsByTagName("security-role");

        Set<String> roles = new HashSet<>();
        for (int i = 0; i < securityRoleElements.getLength(); i++) {
            Node nNode = securityRoleElements.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                NodeList roleNodeList = eElement.getElementsByTagName("role-name");
                if (roleNodeList != null && roleNodeList.getLength() > 0) {
                    roles.add(roleNodeList.item(0).getTextContent().trim());
                }
            }
        }

        return roles;
    }

    public static void main(String[] args) {
    }
}

interface ServletContext {
    public String getRealPath(String path);
}