/*
 * Decompiled with CFR 0.152.
 */
import java.io.StringReader;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.InputSource;

public class Main_706 {
    public static void main(String[] stringArray) throws Exception {
        String string = "<tree><nodea><nodeb>A=foo;B=bar;C=goo;</nodeb></nodea></tree>";
        XPath xPath = XPathFactory.newInstance().newXPath();
        String string2 = (String)xPath.evaluate("//nodea/nodeb/replace(., '.*B=(.*?)\\;.*', '$1')", new InputSource(new StringReader(string)), XPathConstants.STRING);
        System.out.println(string2);
    }
}
