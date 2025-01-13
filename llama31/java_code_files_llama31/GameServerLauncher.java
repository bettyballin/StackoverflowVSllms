/*
 * Decompiled with CFR 0.152.
 */
public class GameServerLauncher {
    public static void main(String[] stringArray) {
        Server server = new Server(8080);
        server.start();
        server.sendDataToAll("Hello, players!");
    }
}
