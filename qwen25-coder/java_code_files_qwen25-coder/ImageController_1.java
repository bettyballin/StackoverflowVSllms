import java.lang.String;
import java.util.List;
import java.util.Collection;

// Stubs for annotations
@interface RestController {}
@interface RequestMapping {
    String value() default "";
}
@interface Autowired {}
@interface GetMapping {
    String value() default "";
}
@interface Service {}
@interface Query {
    String value() default "";
}
@interface Param {
    String value() default "";
}
@interface RequestParam {}

// Stub for ResponseEntity
class ResponseEntity<T> {
    public ResponseEntity(T body, HttpStatus status) {}
}

// Stub for HttpStatus
enum HttpStatus {
    OK
}

// Stub for JpaRepository
interface JpaRepository<T, ID> {}

// Stub for QuerydslPredicateExecutor
interface QuerydslPredicateExecutor<T> {}

// The Image class
class Image {
    public List<String> tags;
    // Constructors, getters, setters, etc.
}

// The ImageController_1 class
@RestController
@RequestMapping("/images")
public class ImageController_1 {

    @Autowired
    private ImageService imageService;

    @GetMapping("/random")
    public ResponseEntity<List<Image>> getRandomImages(@RequestParam List<String> tags) {
        List<Image> randomImages = imageService.findRandomImagesByTags(tags);
        return new ResponseEntity<>(randomImages, HttpStatus.OK);
    }
}

// The ImageService class
@Service
class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<Image> findRandomImagesByTags(List<String> tags) {
        // Logic to fetch random images by tags
        return imageRepository.findRandomByTags(tags);
    }
}

// The ImageRepository interface
interface ImageRepository extends JpaRepository<Image, Long>, QuerydslPredicateExecutor<Image> {

    @Query("SELECT i FROM Image i WHERE :tags MEMBER OF i.tags ORDER BY RAND()")
    List<Image> findRandomByTags(@Param("tags") Collection<String> tags);

    public static void main(String[] args) {
    }
}