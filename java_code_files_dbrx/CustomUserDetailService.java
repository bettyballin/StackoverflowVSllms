import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service("userDetailsService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
        User user = userRepository.findByEmailAddress(username); // Get your user from database. Replace this with what you need to find the user in your repository/dao

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        UserRole userRole = user.getUserRole(); // Assuming user has a method getUserRole()

        List<GrantedAuthority> authorities = buildUserAuthority(userRole.getPermissions()); // This is where you get or construct user permissions from your database for the logged-in user.

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), true, true, true, true, authorities);
    }
    
    private List<GrantedAuthority> buildUserAuthority(Set<String> permissions) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String permission : permissions) {
            authorities.add(new SimpleGrantedAuthority(permission));
        }
        return authorities;
    }

    // Other methods or code...
}

// Minimal UserRepository interface
interface UserRepository {
    User findByEmailAddress(String email);
}

// Minimal User class
class User {
    private String email;
    private String password;
    private UserRole userRole;

    public User(String email, String password, UserRole userRole) {
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}

// Minimal UserRole class
class UserRole {
    private Set<String> permissions;

    public UserRole(Set<String> permissions) {
        this.permissions = permissions;
    }

    public Set<String> getPermissions() {
        return permissions;
    }
}