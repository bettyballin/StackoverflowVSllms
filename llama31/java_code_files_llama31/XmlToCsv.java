/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlToCsv {
    public static void main(String[] stringArray) throws Exception {
        File file = new File("input.xml");
        File file2 = new File("output.csv");
        String string = "<xsl:stylesheet version='1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>\n  <xsl:output method='text'/>\n  <xsl:template match='/Results'>\n    <xsl:for-each select='Row'>\n      <xsl:value-of select='COL1'/>,<xsl:value-of select='COL2'/>,<xsl:value-of select='COL3'/>,<xsl:value-of select='COL4'/>\n      <xsl:text>&#xa;</xsl:text>\n    </xsl:for-each>\n  </xsl:template>\n</xsl:stylesheet>";
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(new StreamSource(new StringReader(string)));
        transformer.setOutputProperty("method", "text");
        transformer.setOutputProperty("encoding", "UTF-8");
        transformer.transform(new StreamSource(file), new StreamResult(new FileOutputStream(file2)));
    }
}
