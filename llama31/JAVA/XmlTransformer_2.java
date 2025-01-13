import java.lang.String;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class XmlTransformer_2_2 {
    public static void main(String[] args) throws TransformerException {
        // Input XML
        String xml = "<customdata>\n" +
                "   <tag1 />\n" +
                "   <tag2>mfkdslmlfkm</tag2>\n" +
                "   <location />\n" +
                "   <tag3 />\n" +
                "</customdata>";

        // XSLT to insert or replace location tag
        String xslt = "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n" +
                "    <xsl:template match=\"@*|node()\">\n" +
                "        <xsl:copy>\n" +
                "            <xsl:apply-templates select=\"@*|node()\"/>\n" +
                "        </xsl:copy>\n" +
                "    </xsl:template>\n" +
                "    <xsl:template match=\"/customdata/location\">\n" +
                "        <location>http://something</location>\n" +
                "    </xsl:template>\n" +
                "    <xsl:template match=\"/customdata[not(location)]\">\n" +
                "        <xsl:copy>\n" +
                "            <xsl:apply-templates select=\"@*|node()\"/>\n" +
                "            <location>http://something</location>\n" +
                "        </xsl:copy>\n" +
                "    </xsl:template>\n" +
                "</xsl:stylesheet>";

        // Create transformer
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(new StringReader(xslt)));

        // Transform XML
        Source xmlSource = new StreamSource(new StringReader(xml));
        StringWriter writer = new StringWriter();
        transformer.transform(xmlSource, new StreamResult(writer));

        // Print transformed XML
        System.out.println(writer.toString());
    }
}