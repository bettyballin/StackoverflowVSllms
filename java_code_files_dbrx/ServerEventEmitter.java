import java.util.Map;

// Minimal annotations to satisfy compiler
@interface Autowired {}
@interface Controller {}

// Minimal interface to satisfy compiler
interface SimpMessageSendingOperations {
    void convertAndSend(String destination, Object payload);
}

@Controller
public class ServerEventEmitter {
    @Autowired private SimpMessageSendingOperations messagingTemplate;
    // Example method that updates vote count for a specific question.
    public void onVoteUpdate(long questionId, int newVotes) {
        String eventKey = "QUESTION_VOTES_" + questionId;
        System.out.println("Publishing update for Question #%d with %d votes".formatted(questionId, newVotes));
        // Prepares a JSON payload and sends it to all subscribers of the 'eventKey'.
        messagingTemplate.convertAndSend("/topic/" + eventKey, Map.of("new_votes", newVotes));
    }

    public static void main(String[] args) {
        // Example usage
        ServerEventEmitter emitter = new ServerEventEmitter();
        emitter.messagingTemplate = new SimpMessageSendingOperations() {
            @Override
            public void convertAndSend(String destination, Object payload) {
                System.out.println("Sending to " + destination + " with payload: " + payload);
            }
        };
        emitter.onVoteUpdate(12345L, 100);
    }
}