import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import java.io.StringWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class VelocityExample {

    public static void main(String[] args) throws Exception {
        // assuming you have an XML file with form fields
        String xml = "<fields><field name='username'/><field name='password'/></fields>";

        // parse the XML and create a VelocityContext
        VelocityContext context = new VelocityContext();
        context.put("fields", parseXmlFields(xml));

        // load the Velocity template
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        Template template = ve.getTemplate("form.vm");

        // merge the template with the context
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        // writer.toString() now contains the generated HTML form
        System.out.println(writer.toString());
    }

    public static NodeList parseXmlFields(String xml) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = factory.newDocumentBuilder().parse(new java.io.ByteArrayInputStream(xml.getBytes()));
        Element root = document.getDocumentElement();
        return root.getChildNodes();
    }
}