import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people/{personId}/messages")
public class MessageController {

  @GetMapping
  public List<Message> getMessages(@PathVariable Long personId) {
    // Return a list of messages for the person
    return null;
  }

  @GetMapping("/{messageId}")
  public Message getMessage(@PathVariable Long personId, @PathVariable Long messageId) {
    // Return a specific message
    return null;
  }

  @PostMapping
  public Message createMessage(@PathVariable Long personId, @RequestBody Message message) {
    // Create a new message on the person's message board
    return null;
  }

  @PostMapping("/{messageId}/replies")
  public Message createReply(@PathVariable Long personId, @PathVariable Long messageId, @RequestBody Message reply) {
    // Create a new reply to a specific message
    return null;
  }

  public static void main(String[] args) {
  }
}