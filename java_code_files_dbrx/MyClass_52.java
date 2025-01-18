import java.lang.String;

@interface Service {}

@interface Autowired {}

@Service
public class MyClass_52 {
    @Autowired private SecurityContext securityContext; // No need to create spring bean

    public static void main(String[] args) {
    }
}

class SecurityContext {}