import java.lang.String;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController_3_3 {

    @GetMapping("/users")
    public ResponseEntity<EntityModel<User>> getUsers() {
        User user = new User("John Doe");
        EntityModel<User> userModel = EntityModel.of(user);
        userModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MyController_3.class).getUser(user.getId())).withRel("self"));
        return ResponseEntity.ok(userModel);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<EntityModel<User>> getUser(@PathVariable Long id) {
        User user = new User("John Doe");
        EntityModel<User> userModel = EntityModel.of(user);
        userModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MyController_3.class).getUsers()).withRel("users"));
        return ResponseEntity.ok(userModel);
    }

    public static void main(String[] args) {
    }
}

class User {
    private String name;
    private Long id;

    public User(String name) {
        this.name = name;
        this.id = 1L; // default id for demonstration purposes
    }

    public Long getId() {
        return id;
    }
}