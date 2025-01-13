/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.http.ResponseEntity
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/game/{gameId}/playerToMove"})
public class PlayerToMoveResource {
    @GetMapping
    public ResponseEntity<String> getPlayerToMove(@PathVariable Long l) {
        Long l2 = 30000L;
        while (l2 > 0L) {
            if (this.hasPlayerMoved(l)) {
                return ResponseEntity.ok((Object)"Your turn to move!");
            }
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
            l2 = l2 - 1000L;
        }
        return ResponseEntity.noContent().build();
    }

    private boolean hasPlayerMoved(Long l) {
        return false;
    }

    public static void main(String[] stringArray) {
    }
}
