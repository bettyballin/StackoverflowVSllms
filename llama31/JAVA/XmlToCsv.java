import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;

public class XmlToCsv {
    public static void main(String[] args) throws Exception {
        // Input XML file
        File xmlFile = new File("input.xml");

        // Output CSV file
        File csvFile = new File("output.csv");

        // XSLT stylesheet
        String xslt = "<xsl:stylesheet version='1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>\n" +
                "  <xsl:output method='text'/>\n" +
                "  <xsl:template match='/Results'>\n" +
                "    <xsl:for-each select='Row'>\n" +
                "      <xsl:value-of select='COL1'/>,<xsl:value-of select='COL2'/>,<xsl:value-of select='COL3'/>,<xsl:value-of select='COL4'/>\n" +
                "      <xsl:text>&#xa;</xsl:text>\n" +
                "    </xsl:for-each>\n" +
                "  </xsl:template>\n" +
                "</xsl:stylesheet>";

        // Create a transformer factory
        TransformerFactory factory = TransformerFactory.newInstance();

        // Create a transformer from the XSLT stylesheet
        Transformer transformer = factory.newTransformer(new StreamSource(new StringReader(xslt)));

        // Set the output properties
        transformer.setOutputProperty(OutputKeys.METHOD, "text");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        // Transform the XML file to CSV
        transformer.transform(new StreamSource(xmlFile), new StreamResult(new FileOutputStream(csvFile)));
    }
}