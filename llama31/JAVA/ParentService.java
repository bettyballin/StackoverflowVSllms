import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

// Domain layer
@Service
public class ParentService {

    private final ParentRepository parentRepository;

    @Autowired
    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Transactional
    public void addChild(Parent parent, Child child) {
        if (parent.getChildren().size() >= 2) {
            throw new BusinessRuleException("Parent can have up to 2 children");
        }
        parent.addChild(child);
        parentRepository.save(parent);
    }

    public static void main(String[] args) {
        // Create an application context
        // This is not possible without the full Spring setup
        // For the sake of this example, we will not create an application context
    }
}

// Repository layer
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ParentRepository extends JpaRepository<Parent, Long> {
    // Spring Data JPA will handle transactions automatically
}

// Domain model
@Entity
class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<Child> children = new ArrayList<>();

    public List<Child> getChildren() {
        return children;
    }

    public void addChild(Child child) {
        children.add(child);
    }
}

@Entity
class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

// Exception handling
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class BusinessRuleExceptionHandler {
    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<ErrorResponse> handleBusinessRuleException(BusinessRuleException ex) {
        // Handle the exception and return an error response
        return ResponseEntity.badRequest().body(new ErrorResponse(ex.getMessage()));
    }
}

class BusinessRuleException extends RuntimeException {
    public BusinessRuleException(String message) {
        super(message);
    }
}

class ErrorResponse {
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}