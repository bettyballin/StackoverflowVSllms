import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.Table;

public class Main_677 {
    public static void main(String[] args) {
        // Create a new Configuration object
        Configuration configuration = new Configuration();

        // Add your entity class to the configuration (replace YourEntityClass with your actual class)
        configuration.addClass(YourEntityClass.class);

        // Create a SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // get the table and column you're interested in
        Table table = configuration.getClassMapping(YourEntityClass.class.getName()).getTable();
        Column column = table.getColumn("yourColumnName");

        // get the column length
        int length = column.getLength();

        System.out.println("Column length: " + length);
    }
}