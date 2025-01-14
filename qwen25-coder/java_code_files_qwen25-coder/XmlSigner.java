import java.lang.String;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.xml.crypto.dsig.*;
import java.security.Security;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Collections;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;

public class XmlSigner {
    public static void main(String[] args) throws Exception {
        // Add BouncyCastle provider to the security providers list
        Security.addProvider(new BouncyCastleProvider());

        // Load the keystore and get the private key
        KeyStore ks = KeyStore.getInstance("PKCS12");
        FileInputStream fis = new FileInputStream("keystore.p12");  // Path to your keystore file
        char[] password = "password".toCharArray();  // Your keystore password
        ks.load(fis, password);

        String alias = "your_alias";  // Alias of the key in your keystore
        PrivateKey privateKey = (PrivateKey) ks.getKey(alias, password);

        // Load the XML document to be signed
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new FileInputStream("input.xml"));  // Path to your XML file

        // Prepare XML signing parameters and sign
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM", new BouncyCastleProvider());
        Reference ref = fac.newReference(
                "",
                fac.newDigestMethod(DigestMethod.SHA256, null),
                Collections.singletonList(fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)),
                null,
                null);

        SignedInfo signedInfo = fac.newSignedInfo(
                fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS,
                        (C14NMethodParameterSpec) null),
                fac.newSignatureMethod(SignatureMethod.RSA_SHA256, null),
                Collections.singletonList(ref));

        KeyInfoFactory kif = fac.getKeyInfoFactory();
        X509Data xd = kif.newX509Data(Collections.singletonList(ks.getCertificate(alias)));
        KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

        XMLSignature signature = fac.newXMLSignature(signedInfo, ki);
        DOMSignContext dsc = new DOMSignContext(privateKey, document.getDocumentElement());

        signature.sign(dsc);
    }
}