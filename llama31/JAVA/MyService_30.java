import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService_30_30 {

    @Autowired
    private MyRepository repository;

    public List<MyEntity> findAll() {
        return repository.findAll();
    }

    public static void main(String[] args) {
    }
}