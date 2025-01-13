import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;

// WebSocket endpoint
@ServerEndpoint("/forum-updates")
public class ForumUpdatesEndpoint {
    private static Set<Session> sessions = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        // Handle new connection
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        // Handle incoming message (not used in this example)
    }

    @OnError
    public void onError(Throwable throwable, Session session) {
        // Handle errors
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        // Handle disconnection
    }

    // Push new post updates to connected clients
    public void broadcastPost(Post post) {
        for (Session session : sessions) {
            try {
                session.getBasicRemote().sendText(post.toString());
            } catch (IOException e) {
                // Handle error
            }
        }
    }

    public static void main(String[] args) {
    }
}

class Post {
    @Override
    public String toString() {
        // Implement Post toString method
        return "";
    }
}