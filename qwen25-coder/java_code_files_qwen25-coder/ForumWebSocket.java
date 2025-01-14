import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/webSocketForum")
public class ForumWebSocket {

    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    @OnMessage
    public void broadcast(String message) throws IOException {
        synchronized (sessions) {
            for (Session session : sessions) {
                session.getBasicRemote().sendText(formatPostXML(message));
            }
        }
    }

    private String formatPostXML(String message) {
        return "<post>" + message + "</post>";
    }

    public static void main(String[] args) {
    }
}