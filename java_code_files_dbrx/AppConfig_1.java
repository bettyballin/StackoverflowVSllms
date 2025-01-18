import java.lang.String;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// Declare this on a configuration class that you want SpringBoot to auto-load via its component scanning feature
@Configuration
@ComponentScan("com.yourpackage") // Replace "com.yourpackage" with your package name
@EnableTransactionManagement // Enables automatic transaction handling based of @Transactional annotations in your services/DAO classes
public class AppConfig_1 { 
	public static void main(String[] args) {
	}
}