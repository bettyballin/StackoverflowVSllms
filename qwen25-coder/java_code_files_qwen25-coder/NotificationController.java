import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NotificationController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private NotificationRepository notificationRepository;

    @Transactional
    @GetMapping("/notifications")
    public ResponseEntity<List<Notification>> getNotifications() {
        // Step 1: Retrieve and lock records
        List<Notification> notifications = entityManager.createQuery(
                "SELECT n FROM Notification n FOR UPDATE", Notification.class)
                .setMaxResults(10) // Limit the number of notifications retrieved
                .getResultList();

        if (notifications.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        try {
            // Step 2: Convert to JSON and send to client
            List<NotificationDto> notificationDtos = notifications.stream()
                    .map(NotificationMapper::toDto)
                    .collect(Collectors.toList());

            // Simulate sending data (e.g., returning response entity)
            ResponseEntity<List<NotificationDto>> responseEntity = new ResponseEntity<>(notificationDtos, HttpStatus.OK);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                // Step 3: If successful, delete the records
                notificationRepository.deleteAll(notifications);
                return responseEntity;
            } else {
                // Handle error cases based on the response code
                throw new RuntimeException("Failed to send notifications");
            }
        } catch (Exception e) {
            // In case of any exception, roll back the transaction (due to @Transactional)
            throw new RuntimeException("Error processing notifications", e);
        }
    }

    public static void main(String[] args) {
    }
}

// Stub classes to make the code executable
class Notification {
    // Add fields and methods as needed
}

class NotificationDto {
    // Add fields and methods as needed
}

class NotificationMapper {
    public static NotificationDto toDto(Notification notification) {
        return new NotificationDto();
    }
}

interface NotificationRepository {
    void deleteAll(List<Notification> notifications);
}