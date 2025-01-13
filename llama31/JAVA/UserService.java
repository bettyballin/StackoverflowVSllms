import java.lang.String;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User getAttachedUser(Long userId) {
        // Load the user by ID to attach it to the Hibernate session
        return userDAO.findById(userId).orElseThrow();
    }

    public static void main(String[] args) {
    }
}