import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class MyController_7 {

    @Autowired
    private MyDao myDao;

    @GetMapping("/entities")
    public List<MyEntity> getEntities() {
        return myDao.findAll();
    }

    @PostMapping("/entity")
    public MyEntity createEntity(@RequestBody MyEntity entity) {
        return myDao.save(entity);
    }

    public static void main(String[] args) {
    }
}

interface MyDao {
    List<MyEntity> findAll();
    MyEntity save(MyEntity entity);
}

class MyEntity {
}