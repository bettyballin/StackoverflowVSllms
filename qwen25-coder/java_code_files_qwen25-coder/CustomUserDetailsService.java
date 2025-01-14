import java.lang.String;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;  
import org.springframework.security.core.userdetails.UserDetailsService;  
import org.springframework.security.core.userdetails.UsernameNotFoundException;  
import org.springframework.security.core.userdetails.User;

public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new User(
                user.getUsername(), 
                user.getPassword(), 
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());
    }

    public static void main(String[] args) {
    }
}

// Additional classes to make the code executable
class UserRepository {
    public UserEntity findByUsername(String username) {
        // Placeholder implementation
        return new UserEntity();
    }
}

class UserEntity {
    public String getUsername() {
        return "user";
    }

    public String getPassword() {
        return "password";
    }

    public Collection<Role> getRoles() {
        // Placeholder implementation
        return java.util.Arrays.asList(new Role());
    }
}

class Role {
    public String getName() {
        return "ROLE_USER";
    }
}