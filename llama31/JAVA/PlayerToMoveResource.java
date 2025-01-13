import java.lang.String;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/game/{gameId}/playerToMove")
public class PlayerToMoveResource {

    @GetMapping
    public ResponseEntity<String> getPlayerToMove(@PathVariable Long gameId) {
        // Keep the connection open for 30 seconds
        Long timeout = 30000L;
        while (timeout > 0) {
            if (hasPlayerMoved(gameId)) {
                return ResponseEntity.ok("Your turn to move!");
            }
            try {
                Thread.sleep(1000); // sleep for 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            timeout -= 1000;
        }
        return ResponseEntity.noContent().build(); // return empty response
    }

    private boolean hasPlayerMoved(Long gameId) {
        // implement logic to check if player has moved
        return false; // replace with actual logic
    }

    public static void main(String[] args) {
    }
}