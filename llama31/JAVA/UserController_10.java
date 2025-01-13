import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class UserController_10_10 {
    private MyDao myDao;

    @GetMapping("/users")
    @ResponseBody
    public List<User> getUsers() {
        return myDao.getUsers();
    }

    public static void main(String[] args) {
    }
}