import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.transaction.TransactionDefinition;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

    @Bean
    public HibernateTransactionManager transactionManager(EntityManagerFactory emf) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        // Set the default isolation level to READ COMMITTED
        transactionManager.setDefaultIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        return transactionManager;
    }

    public static void main(String[] args) {
    }
}