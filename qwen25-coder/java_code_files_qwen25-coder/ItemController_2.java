import java.lang.String;
import java.util.Optional;

// Import statements for Spring annotations and classes
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

// Controller
@RestController
@RequestMapping("/items")
public class ItemController_2 {

    @Autowired
    private ItemService itemService;

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItem(@PathVariable Long id) {
        ItemDTO itemDTO = itemService.getItemById(id);
        return ResponseEntity.ok(itemDTO);
    }
}

// Service Interface
interface ItemService {
    ItemDTO getItemById(Long id);
}

// Service Implementation
@Service
class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ItemDTO getItemById(Long id) {
        // Load the domain object from repository using ID
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id));
        
        // Convert domain object to DTO for response
        return convertToDTO(item);
    }

    private ItemDTO convertToDTO(Item item) {
        ItemDTO dto = new ItemDTO();
        BeanUtils.copyProperties(item, dto);
        // Additional conversion logic can go here
        return dto;
    }
}

// Repository Interface (Simplified for compilation)
interface ItemRepository {
    Optional<Item> findById(Long id);
}

// Domain Class
class Item {
    // Item properties and methods
}

// Data Transfer Object Class
class ItemDTO {
    // ItemDTO properties and methods
}

// Custom Exception Class
class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

// Placeholder for BeanUtils (Simplified for compilation)
class BeanUtils {
    public static void copyProperties(Object source, Object target) {
        // Implement property copying logic
    }
}

// Placeholder for ResponseEntity (Simplified for compilation)
class ResponseEntity<T> {
    private T body;

    private ResponseEntity(T body) {
        this.body = body;
    }

    public static <T> ResponseEntity<T> ok(T body) {
        return new ResponseEntity<>(body);
    }
}