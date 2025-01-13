/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ResultSetSource
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class SqlToXml {
    public static void main(String[] stringArray) throws SQLException, TransformerException {
        Connection connection = DriverManager.getConnection("your_database_url", "username", "password");
        String string = "SELECT * FROM your_table";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(string);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty("omit-xml-declaration", "yes");
        transformer.setOutputProperty("method", "xml");
        transformer.setOutputProperty("indent", "yes");
        StreamResult streamResult = new StreamResult(System.out);
        transformer.transform((Source)new ResultSetSource(resultSet), streamResult);
    }
}
