import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.io.IOException;

import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat") // change this endpoint as you see fit
public class ChatEndpoint {
    private static final Set<Session> sessions = new CopyOnWriteArraySet<>(); // ConcurrentHashMap is not needed because ServerEndpoint handles concurrency for us

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }

    /** To close the connection */
    @OnClose
    public void onClose(Session session) {
        sessions.remove(session); // remove this from set when closing a session
    }

    /** On receiving message from client */
    @OnMessage
    public String onMessage(String msg, Session sender) throws IOException {
        for (Session session : sessions) {   // Send back the same thing to all clients connected.
            if (!session.equals(sender))     // Don't send it to yourself!
                session.getBasicRemote().sendText("You: " + msg); // Change this line of code as you see fit and send message through your application.
        }

        return null;
    }

    public static void main(String[] args) {
    }
}