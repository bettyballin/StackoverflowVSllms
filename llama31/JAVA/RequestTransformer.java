import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.servlet.http.HttpServletRequest;

public class RequestTransformer {
    public static void main(String[] args) throws Exception {
        HttpServletRequest request = null; // You need to get the HttpServletRequest object from somewhere, e.g., a servlet
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setParameter("color", request.getParameter("color"));
        transformer.setParameter("number", request.getParameter("number"));
    }
}