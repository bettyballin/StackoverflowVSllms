import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

// Define @Service annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Service {
    String value() default "";
}

// Define @Autowired annotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@interface Autowired {
}

// Define UserDetails interface
interface UserDetails {
    String getUsername();
    String getPassword();
    List<GrantedAuthority> getAuthorities();
    boolean isAccountNonExpired();
    boolean isAccountNonLocked();
    boolean isCredentialsNonExpired();
    boolean isEnabled();
}

// Define UserDetailsService interface
interface UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

// Define UsernameNotFoundException
class UsernameNotFoundException extends Exception {
    public UsernameNotFoundException(String msg){
        super(msg);
    }
}

// Define GrantedAuthority interface
interface GrantedAuthority {
    String getAuthority();
}

// Define SimpleGrantedAuthority class
class SimpleGrantedAuthority implements GrantedAuthority {
    private String role;

    public SimpleGrantedAuthority(String role){
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}

// Define User class
class User implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;
    private boolean disabled;

    public User(String username, String password, List<GrantedAuthority> authorities,
                boolean accountExpired, boolean accountLocked, boolean credentialsExpired, boolean disabled){
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.accountExpired = accountExpired;
        this.accountLocked = accountLocked;
        this.credentialsExpired = credentialsExpired;
        this.disabled = disabled;
    }

    public static UserBuilder withUsername(String username){
        return new UserBuilder().withUsername(username);
    }

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public List<GrantedAuthority> getAuthorities(){
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired(){
        return !accountExpired;
    }

    @Override
    public boolean isAccountNonLocked(){
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return !credentialsExpired;
    }

    @Override
    public boolean isEnabled(){
        return !disabled;
    }

    public static class UserBuilder {
        private String username;
        private String password;
        private List<GrantedAuthority> authorities = new ArrayList<>();
        private boolean accountExpired;
        private boolean accountLocked;
        private boolean credentialsExpired;
        private boolean disabled;

        public UserBuilder withUsername(String username){
            this.username = username;
            return this;
        }

        public UserBuilder password(String password){
            this.password = password;
            return this;
        }

        public UserBuilder authorities(List<GrantedAuthority> authorities){
            this.authorities = authorities;
            return this;
        }

        public UserBuilder accountExpired(boolean accountExpired){
            this.accountExpired = accountExpired;
            return this;
        }

        public UserBuilder accountLocked(boolean accountLocked){
            this.accountLocked = accountLocked;
            return this;
        }

        public UserBuilder credentialsExpired(boolean credentialsExpired){
            this.credentialsExpired = credentialsExpired;
            return this;
        }

        public UserBuilder disabled(boolean disabled){
            this.disabled = disabled;
            return this;
        }

        public User build(){
            return new User(username, password, authorities, accountExpired, accountLocked, credentialsExpired, disabled);
        }
    }
}

// Define the YourRepository interface
interface YourRepository {
    Optional<YourDomainUser> findByIdentifier(String username);
}

// Define the YourDomainUser class
class YourDomainUser {
    private String username;
    private String password;
    private List<String> roles;

    public YourDomainUser(String username, String password, List<String> roles){
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public List<String> getRoles(){
        return roles;
    }
}

// Define the EntityNotFoundException
class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entity, String field, String value){
        super(String.format("%s not found with %s : '%s'", entity, field, value));
    }
}

@Service("databaseUserDetailService")
public class DatabaseUserDetailService implements UserDetailsService {

    @Autowired
    private YourRepository repository;   // Replace this with your actual implementation.

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<YourDomainUser> user  = repository.findByIdentifier(username); // Replace with your own implementation.
        if(!user.isPresent()){
            throw new EntityNotFoundException("user","email",username);   // Implement suitable exception handling.
        }
        List<GrantedAuthority> authorities = buildUserAuthority(user.get().getRoles());    // Replace with your own implementation.

        return User
            .withUsername(username)
            .password(user.get().getPassword()) // Replace with actual password fetched from DB.
            .authorities(authorities)
            .accountExpired(false)
            .accountLocked(false)
            .credentialsExpired(false) // Set correct values based on user retrieved from DB.
            .disabled(false)  // Configure all other needed attributes accordingly.
            .build();
    }

    private List<GrantedAuthority> buildUserAuthority(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(String role : roles){
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}