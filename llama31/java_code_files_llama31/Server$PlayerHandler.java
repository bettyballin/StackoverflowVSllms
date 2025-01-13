/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

private class Server.PlayerHandler
extends Thread {
    private Socket socket;
    private ObjectOutputStream out;

    public Server.PlayerHandler(Server server, Socket socket) throws IOException {
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
    }

    public void sendData(String string) throws IOException {
        this.out.writeObject(string);
        this.out.flush();
    }
}
