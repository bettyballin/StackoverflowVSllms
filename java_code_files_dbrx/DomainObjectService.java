import java.util.Optional;

@interface Service {
}

@interface Autowired {
}

@interface NonNull {
}

// Exception class
class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }
}

// DomainObject class
class DomainObject {
    // Empty implementation for compilation
}

// ResultType class
class ResultType {
    // Empty implementation for compilation
}

// ObjectRepository interface
interface ObjectRepository {
    Optional<DomainObject> findById(Long id);
}

@Service
public class DomainObjectService {

    private final ObjectRepository repository;

    @Autowired
    public DomainObjectService(ObjectRepository repository) {
        this.repository = repository;
    }

    // Interface takes ID, but internally works with domain object
    public ResultType processById(@NonNull Long id) throws NotFoundException {
        Optional<DomainObject> objOpt = repository.findById(id);
        if (objOpt.isEmpty()) {
            throw new NotFoundException("No Domain Object found for ID=" + id);
        }
        return process(objOpt.get());   // Here we handle domain model instances internally
    }

    public ResultType process(@NonNull DomainObject obj) {
        // Processing goes here, based on concrete business need
        return new ResultType();
    }

    public static void main(String[] args) {
        // Main method implementation
    }
}