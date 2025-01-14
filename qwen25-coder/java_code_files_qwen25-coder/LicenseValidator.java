import java.io.File;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.dom.DOMValidateContext;

public class LicenseValidator {

    public boolean validateLicense(String licenseFilePath) {
        try {
            // Load public key from embedded resources
            PublicKey publicKey = loadPublicKeyFromResources();

            // Parse XML and check signature
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(licenseFilePath));

            NodeList nodeList = doc.getElementsByTagNameNS("http://www.w3.org/2000/09/xmldsig#", "Signature");
            if (nodeList.getLength() == 0) {
                throw new Exception("Invalid license format: No signature found.");
            }
            XMLSignatureFactory sigFactory = XMLSignatureFactory.getInstance("DOM");
            Node dsNode = nodeList.item(0);
            DOMValidateContext valContext = new DOMValidateContext(publicKey, dsNode.getParentNode());
            XMLSignature signature = sigFactory.unmarshalXMLSignature(valContext);
            if (!signature.validate(valContext)) {
                throw new Exception("Invalid license: Signature does not match.");
            }

            // Check expiration date and product name
            String productName = doc.getElementsByTagName("ProductName").item(0).getTextContent();
            Date expireDate = parseDate(doc.getElementsByTagName("ExpireDate").item(0).getTextContent());
            if (!productName.equals("ExpectedProductName") || new Date().after(expireDate)) {
                throw new Exception("License validation failed: Incorrect product name or expired.");
            }

            return true;
        } catch (Exception e) {
            System.err.println("Error validating license: " + e.getMessage());
            return false;
        }
    }

    private PublicKey loadPublicKeyFromResources() throws Exception {
        // TODO: Implement method to load public key from resources
        throw new UnsupportedOperationException("Not implemented.");
    }

    private Date parseDate(String dateString) throws Exception {
        // Parse date from string
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(dateString);
    }

    public static void main(String[] args) {
        // You can test the validateLicense method here
    }
}