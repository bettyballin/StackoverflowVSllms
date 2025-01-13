import java.lang.String;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.annotation.WebSocket;

import java.lang.InterruptedException;

@RestController
@RequestMapping("/game/{gameId}/playerToMove")
public class PlayerToMoveResource_1_1 {
    @WebSocket("/game/{gameId}/playerToMove")
    public void playerToMove(WebSocketSession session, @PathVariable Long gameId) {
        // Handle WebSocket connection
        while (session.isOpen()) {
            if (hasPlayerMoved(gameId)) {
                try {
                    session.sendMessage("Your turn to move!");
                } catch (Exception e) {
                    // Handle exception
                }
            }
            try {
                Thread.sleep(1000); // sleep for 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private boolean hasPlayerMoved(Long gameId) {
        // implement logic to check if player has moved
        return false;
    }

    public static void main(String[] args) {
    }
}