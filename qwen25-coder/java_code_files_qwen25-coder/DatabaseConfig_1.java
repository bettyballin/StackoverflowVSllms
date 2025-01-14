import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class DatabaseConfig_1 {

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("dataSource1") DataSource dataSource1,
            @Qualifier("dataSource2") DataSource dataSource2) {
        Map<String, Object> properties = new HashMap<>();
        // set common JPA properties

        return builder.dataSource(dataSource1)
                .packages("com.example.entity")
                .persistenceUnit("pu1")
                .properties(properties)
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory2(
            EntityManagerFactoryBuilder builder, @Qualifier("dataSource2") DataSource dataSource2) {
        Map<String, Object> properties = new HashMap<>();
        // set common JPA properties

        return builder.dataSource(dataSource2)
                .packages("com.example.entity")
                .persistenceUnit("pu2")
                .properties(properties)
                .build();
    }

    public static void main(String[] args) {
    }
}