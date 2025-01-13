/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class MaxNavOrder {
    public static void main(String[] stringArray) throws Exception {
        String string = "<root title=\"\u0627\u0644\u0635\u0641\u062d\u0629 \u0627\u0644\u0631\u0626\u064a\u0633\u0629\">   <item title=\"\u0627\u0644\u0635\u0641\u062d\u0629 \u0627\u0644\u0631\u0626\u064a\u0633\u0629\" itemuri=\"tcm:8-29-4\" ShowInNav=\"True\" type=\"sg\" pageuri=\"tcm:8-10592-64\" sLink=\"/ara/index.aspx\">      <item title=\"\u0645\u0646 \u0646\u062d\u0646\" itemuri=\"tcm:8-779-4\" ShowInNav=\"True\" type=\"sg\" pageuri=\"tcm:8-9934-64\" navorder=\"00500\" sLink=\"/ara/about/index.aspx\">      </item>      <item title=\"\u0628\u0631\u0627\u0645\u062c\u0646\u0627\" itemuri=\"tcm:8-817-4\" ShowInNav=\"True\" type=\"sg\" pageuri=\"tcm:8-10112-64\" navorder=\"00100\" sLink=\"/ara/courses/language-study-abroad.aspx\">      </item>      <item title=\"\u0645\u062f\u0627\u0631\u0633\u0646\u0627\" itemuri=\"tcm:8-824-4\" ShowInNav=\"True\" type=\"sg\" pageuri=\"tcm:8-10162-64\" navorder=\"00300\" sLink=\"/ara/schools/english-language.aspx\">      </item>   </item></root>";
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(string.getBytes()));
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList)xPath.compile("//item/@navorder").evaluate(document, XPathConstants.NODESET);
        int n = 0;
        for (int i = 0; i < nodeList.getLength(); ++i) {
            int n2 = Integer.parseInt(nodeList.item(i).getNodeValue());
            if (n2 <= n) continue;
            n = n2;
        }
        System.out.println("Max navorder: " + n);
    }
}
