import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.annotation.WebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;

// Using Spring Boot and WebSockets
@RestController
public class SlaveServerController extends TextWebSocketHandler {
    @Autowired
    private StringProcessingService stringProcessingService;
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Handle master server connections and disconnections
    }
    
    public void sendData(String data) {
        // Process data using string processing service
        String result = stringProcessingService.process(data);
        
        // Send result back to master server
        session.sendMessage(new TextMessage(result));
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Handle incoming messages from master server
        sendData(message.getText());
    }

	public static void main(String[] args) {
	}
}