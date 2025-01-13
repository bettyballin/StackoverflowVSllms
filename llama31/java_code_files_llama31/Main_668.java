/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Main_668 {
    public static void main(String[] stringArray) throws Exception {
        System.setProperty("javax.xml.transform.TransformerFactory", "org.apache.xalan.processor.TransformerFactoryImpl");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        FileInputStream fileInputStream = new FileInputStream("transform.xsl");
        FileInputStream fileInputStream2 = new FileInputStream("input.xml");
        FileOutputStream fileOutputStream = new FileOutputStream("output.xml");
        Transformer transformer = transformerFactory.newTransformer(new StreamSource(fileInputStream));
        transformer.transform(new StreamSource(fileInputStream2), new StreamResult(fileOutputStream));
        fileInputStream.close();
        fileInputStream2.close();
        fileOutputStream.close();
    }
}
