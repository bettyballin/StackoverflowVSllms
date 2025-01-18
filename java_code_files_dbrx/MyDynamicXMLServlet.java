import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import java.io.StringWriter;

@WebServlet("/MyDynamicXMLServlet") // example servlet url pattern
public class MyDynamicXMLServlet extends HttpServlet {
    @Override 
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            // CREATE DOC ELEMENTS HERE, EXAMPLE BELOW:
            Element rootNameElement = doc.createElement("root");
            rootNameElement.appendChild(doc.createTextNode("Some Content"));
            doc.appendChild(rootNameElement);

            // TRANSLATION FROM XML SYNTAX TO STRING AND WRITE INTO HTTP RESPONSE
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1"); // encoding to be used in this response (can be changed)
            StringWriter sw = new StringWriter();
            tf.transform(new DOMSource(doc.getDocumentElement()), new StreamResult(sw));
            resp.setContentType("text/xml");
            // OR RESPONSE CAN BE SET TO APPLICATION/XML FOR OTHER USES
            resp.getWriter().print(sw.toString());
        } catch (Exception ex) {
            throw new ServletException("Error creating xml", ex);
        }
    }
}