import java.lang.annotation.*;

public class MyClass {

    @Autowired
    private SecurityContextProvider securityContextProvider;

    // Inside one of your methods
    public void myMethod() {
        Authentication authentication = securityContextProvider.getAuthentication();
        if (authentication != null) {
            GrantedAuthority[] authorities = authentication.getAuthorities();
            // Do something with authorities
        }
    }
}

// Define Autowired annotation
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface Autowired {}

// Assuming the following interfaces are defined elsewhere in your project:

interface SecurityContextProvider {
    Authentication getAuthentication();
}

interface Authentication {
    GrantedAuthority[] getAuthorities();
}

interface GrantedAuthority {
    String getAuthority();
}