import org.springframework.roo.addon.dbre.Dbre;
import org.springframework.roo.addon.jpa.JpaOperations;

public class GenerateJavaCode_1_1 {
    public static void main(String[] args) {
        // Create a new DBRE instance
        Dbre dbre = new Dbre();
        
        // Reverse-engineer the database schema
        dbre.reverseEngineer();
        
        // Generate the Java domain model
        JpaOperations jpaOps = new JpaOperations();
        jpaOps.generateEntities();
    }
}