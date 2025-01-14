import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import java.util.Set;

public class ColumnLengthChecker {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your-persistence-unit");

        // Get the entity manager
        EntityManager entityManager = emf.createEntityManager();

        // Unwrap the SessionFactory from the EntityManagerFactory
        SessionFactory sessionFactory = emf.unwrap(SessionFactory.class);

        // Access the metamodel to retrieve entity metadata
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        for (EntityType<?> entity : entities) {
            System.out.println("Entity: " + entity.getName());

            // Get Hibernate ClassMetadata
            ClassMetadata classMetadata = sessionFactory.getClassMetadata(entity.getJavaType());

            if (classMetadata instanceof AbstractEntityPersister) {
                AbstractEntityPersister persister = (AbstractEntityPersister) classMetadata;

                for (Attribute<?, ?> attribute : entity.getDeclaredAttributes()) {
                    // Get column names for the attribute
                    String[] columnNames = persister.getPropertyColumnNames(attribute.getName());

                    if (columnNames != null && columnNames.length > 0) {
                        String columnName = columnNames[0];

                        // Here, you might need additional logic to retrieve the column length
                        // depending on your Hibernate version and configuration.
                        // For simplicity, we'll just print the column name.

                        System.out.println("Attribute: " + attribute.getName() + ", Column: " + columnName);
                    } else {
                        System.out.println("Attribute: " + attribute.getName() + ", Column: N/A");
                    }
                }
            } else {
                System.out.println("ClassMetadata is not an instance of AbstractEntityPersister");
            }
        }

        entityManager.close();
        emf.close();
    }
}