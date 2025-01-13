import java.lang.String;
import java.util.EnumSet;

// Example usage of Hibernate Tools
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.Action;
import org.hibernate.tool.schema.Target;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GenerateJavaCode {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SchemaExport export = new SchemaExport(cfg);
        export.setDelimiter(";");
        export.setOutputFile("schema.sql");
        export.setFormat(true);
        export.setHaltOnError(true);
        export.execute(EnumSet.of(Target.SCRIPT), Action.CREATE);
    }
}