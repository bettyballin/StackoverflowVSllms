import org.exist.xmldb.XmldbURI;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceSet;

public class Main_134 {
    public static void main(String[] args) throws Exception {
        // Create a connection to the database
        Database db = DatabaseManager.getDatabase("xmldb:exist://localhost:8080/exist/xmlrpc");

        // Get a collection object
        Collection col = db.getCollection("/db");

        // Store an XML document
        String xml = "<example><name>John</name><age>30</age></example>";
        col.storeResource(new XmldbURI("example.xml"), xml);

        // Query the XML document
        String xquery = "for $doc in collection('/db')//example return $doc/name";
        ResourceSet results = col.query(xquery);

        // Process the results
        while (results.hasMoreResources()) {
            Resource res = results.nextResource();
            System.out.println(res.getContent());
        }
    }
}