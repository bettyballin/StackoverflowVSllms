/*
 * Decompiled with CFR 0.152.
 */
import java.nio.channels.SocketChannel;

class Listener {
    private String name;

    public Listener(String string) {
        this.name = string;
    }

    public void addSocketChannel(SocketChannel socketChannel) {
        System.out.println("Client connected: " + String.valueOf(socketChannel));
    }
}
