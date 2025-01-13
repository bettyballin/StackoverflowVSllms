import org.apache.xmlbeans.xsd2db.Xsd2Db;

public class Xsd2Sql {
    public static void main(String[] args) {
        String xsdFile = "path/to/your/xsd/file.xsd";
        String dbSchema = "your_schema_name";
        String dbType = "oracle11"; // Use "oracle11" for Oracle 11g

        Xsd2Db xsd2Db = new Xsd2Db();
        xsd2Db.setXsd(xsdFile);
        xsd2Db.setDbSchema(dbSchema);
        xsd2Db.setDbType(dbType);

        xsd2Db.generateSchema();
    }
}