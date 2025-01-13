import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.spi.SchemaExport;
import org.hibernate.tool.schema.spi.SchemaExport.Action;

public class Main_332 {
    public static void main(String[] args) {
        // Create a JPA configuration
        Configuration cfg = new Configuration();
        cfg.configure("persistence.xml");

        // Create a schema export object
        SchemaExport export = new SchemaExport(cfg);

        // Execute the export
        export.execute(Action.CREATE, true, false, true, "schema.sql");
    }
}