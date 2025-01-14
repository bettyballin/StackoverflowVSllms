import java.lang.String;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class AppConfig_1 {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(userRepository);
    }

    public static void main(String[] args) {
    }
}

// Definition of UserRepository
interface UserRepository {
    // methods
}

// Definition of UserDetailsService
interface UserDetailsService {
    // methods
}

// Definition of CustomUserDetailsService
class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // implementation of UserDetailsService methods
}