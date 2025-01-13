/*
 * Decompiled with CFR 0.152.
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlFactoryConfigurator {
    public static void main(String[] stringArray) throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setFeature("http://apache.org/xml/features/validation/schema", false);
    }
}
