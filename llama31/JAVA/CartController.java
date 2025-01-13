import java.lang.String;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class CartController {
    @RequestMapping(method = RequestMethod.PATCH, value = "/carts/{cartId}")
    public ResponseEntity<Void> clearCart(@PathVariable Long cartId) {
        // Clear the cart logic
        return ResponseEntity.ok().build();
    }
    public static void main(String[] args) {
    }
}