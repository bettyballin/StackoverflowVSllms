import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

public class Main_773 {
    public static void main(String[] args) throws XQException {
        // Load the XML document
        XQDataSource dataSource = new net.sf.saxon.xqj.SaxonXQDataSource();
        XQConnection connection = dataSource.getConnection();

        // Create an XQuery instance
        String query = "for $node in doc('example.xml')//node[@id='1'] return $node/name";
        XQPreparedExpression expression = connection.prepareExpression(query);

        // Execute the query
        XQResultSequence result = expression.executeQuery();

        // Print the result
        while (result.next()) {
            System.out.println(result.getItemAsString(null));
        }

        // Close the connection
        connection.close();
    }
}