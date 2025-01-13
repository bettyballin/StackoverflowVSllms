/*
 * Decompiled with CFR 0.152.
 */
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlTransformer_1 {
    public static void main(String[] stringArray) throws TransformerException {
        StreamSource streamSource = new StreamSource("internal.xml");
        StreamSource streamSource2 = new StreamSource("transform.xsl");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(streamSource2);
        StreamResult streamResult = new StreamResult("external.xml");
        transformer.transform(streamSource, streamResult);
    }
}
