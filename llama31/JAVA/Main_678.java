import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.metamodel.relational.RelationalValue;
import org.hibernate.metamodel.relational.Table;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaExport.Action;
import org.hibernate.tool.schema.TargetType;

// Assuming you have a Hibernate entity class
class YourEntityClass {
    private String yourColumnName;

    public String getYourColumnName() {
        return yourColumnName;
    }

    public void setYourColumnName(String yourColumnName) {
        this.yourColumnName = yourColumnName;
    }
}

public class Main_678 {
    public static void main(String[] args) {
        // Create the ServiceRegistry from hibernate.cfg.xml
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        // Create a metadata sources using the specified service registry
        MetadataSources metadataSources = new MetadataSources(serviceRegistry);

        // Add your entity class to the metadata sources
        metadataSources.addAnnotatedClass(YourEntityClass.class);

        // Create metadata
        Metadata metadata = metadataSources.buildMetadata();

        // Get the table and column you're interested in
        Table table = metadata.getEntityBinding(YourEntityClass.class.getName()).getTable();
        RelationalValue column = table.getRelationalValue("yourColumnName");

        // Get the column length
        int length = column.getJdbcType().getColumnLength();

        // Print the column length
        System.out.println("Column length: " + length);
    }
}