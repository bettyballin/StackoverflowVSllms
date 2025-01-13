import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController_15_15 {
    @Autowired
    private MyDao myDao;
    
    @GetMapping("/users")
    public List<User> getUsers() {
        return myDao.getUsers();
    }

    public static void main(String[] args) {
    }
}