import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl_2 implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl_2(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User lookupUser(String webUserId) {
        return userDao.lookupUser(webUserId);
    }

    public static void main(String[] args) {
    }
}