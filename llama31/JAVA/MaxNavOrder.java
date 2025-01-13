import java.lang.String;
import java.lang.Integer;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class MaxNavOrder {
    public static void main(String[] args) throws Exception {
        String xml = "<root title=\"الصفحة الرئيسة\">" +
                "   <item title=\"الصفحة الرئيسة\" itemuri=\"tcm:8-29-4\" ShowInNav=\"True\" type=\"sg\" pageuri=\"tcm:8-10592-64\" sLink=\"/ara/index.aspx\">" +
                "      <item title=\"من نحن\" itemuri=\"tcm:8-779-4\" ShowInNav=\"True\" type=\"sg\" pageuri=\"tcm:8-9934-64\" navorder=\"00500\" sLink=\"/ara/about/index.aspx\">" +
                "      </item>" +
                "      <item title=\"برامجنا\" itemuri=\"tcm:8-817-4\" ShowInNav=\"True\" type=\"sg\" pageuri=\"tcm:8-10112-64\" navorder=\"00100\" sLink=\"/ara/courses/language-study-abroad.aspx\">" +
                "      </item>" +
                "      <item title=\"مدارسنا\" itemuri=\"tcm:8-824-4\" ShowInNav=\"True\" type=\"sg\" pageuri=\"tcm:8-10162-64\" navorder=\"00300\" sLink=\"/ara/schools/english-language.aspx\">" +
                "      </item>" +
                "   </item>" +
                "</root>";

        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new java.io.ByteArrayInputStream(xml.getBytes()));
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList) xPath.compile("//item/@navorder").evaluate(doc, XPathConstants.NODESET);

        int maxNavOrder = 0;
        for (int i = 0; i < nodeList.getLength(); i++) {
            int navOrder = Integer.parseInt(nodeList.item(i).getNodeValue());
            if (navOrder > maxNavOrder) {
                maxNavOrder = navOrder;
            }
        }

        System.out.println("Max navorder: " + maxNavOrder);
    }
}