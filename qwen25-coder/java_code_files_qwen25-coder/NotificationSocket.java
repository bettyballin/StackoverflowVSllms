import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

// Example of a basic WebSocket endpoint in Java using Spring Boot
@ServerEndpoint("/notifications")
public class NotificationSocket {
    private static Set<Session> sessions = ConcurrentHashMap.newKeySet();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        // Handle incoming messages (could be subscription requests)
    }

    @OnError
    public void onError(Session session, Throwable throwable){
        sessions.remove(session);
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        sessions.remove(session);
    }

    public static void notifySubscribers(String message) throws IOException {
        for (Session session : sessions) {
            synchronized (session) {
                session.getBasicRemote().sendText(message);
            }
        }
    }
}

public class MainApplication {
    public static void main(String[] args) {
        // Entry point of the application
        // Initialize the WebSocket server or Spring Boot application here
    }
}