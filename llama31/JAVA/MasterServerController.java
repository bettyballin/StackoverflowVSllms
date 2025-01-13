import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@RestController
@EnableWebSocket
public class MasterServerController implements WebSocketConfigurer {

    @Autowired
    private SlaveServerService slaveServerService;

    @PostMapping("/process")
    public String process(@RequestBody String data) {
        // Find available slave server
        SlaveServer slaveServer = slaveServerService.getAvailableSlaveServer();
        
        // Send data to slave server
        slaveServer.sendData(data);
        
        // Return response to client
        return "Processing...";
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new SlaveServerWebSocketHandler(), "/slave-servers").setAllowedOrigins("*");
    }

    private class SlaveServerWebSocketHandler implements org.springframework.web.socket.WebSocketHandler {

        @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
            // Handle slave server connections
        }

        @Override
        public void handleMessage(WebSocketSession session, org.springframework.web.socket.WebSocketMessage<?> message) throws Exception {
            // Handle messages from slave servers
        }

        @Override
        public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
            // Handle transport errors
        }

        @Override
        public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus status) throws Exception {
            // Handle slave server disconnections
        }

        @Override
        public boolean supportsPartialMessages() {
            return false;
        }
    }

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(MasterServerController.class, args);
    }
}