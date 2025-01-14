import org.hibernate.mapping.Column;
import org.hibernate.mapping.Table;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;

public class SchemaAnalyzer {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        // configure Hibernate with your connection settings here
        cfg.configure();  // loads hibernate.cfg.xml

        Iterator<Table> tables = cfg.getTableMappings();

        while (tables.hasNext()) {
            Table table = tables.next();
            System.out.println("Table: " + table.getName());
            Iterator columns = table.getColumnIterator();
            while (columns.hasNext()) {
                Object col = columns.next();
                // Assuming a simple method to access column information
                System.out.println("Column: " + col);
            }
        }
    }
}