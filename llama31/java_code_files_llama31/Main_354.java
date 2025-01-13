/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

public class Main_354 {
    public static void main(String[] stringArray) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("path/to/keystore.jks"), "password".toCharArray());
        X509Certificate x509Certificate = (X509Certificate)keyStore.getCertificate("alias");
        PrivateKey privateKey = (PrivateKey)keyStore.getKey("alias", "password".toCharArray());
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document document = documentBuilderFactory.newDocumentBuilder().parse(new FileInputStream("path/to/saml_request.xml"));
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        DOMSource dOMSource = new DOMSource(document);
        transformerFactory.newTransformer().transform(dOMSource, new StreamResult(System.out));
        System.out.println(document.getDocumentElement());
    }
}
