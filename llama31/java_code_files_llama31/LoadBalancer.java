/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {
    private List<Server> servers;
    private int currentServerIndex = 0;

    public LoadBalancer(List<Server> list) {
        this.servers = list;
    }

    public Server getAvailableServer() {
        Server server = this.servers.get(this.currentServerIndex);
        this.currentServerIndex = (this.currentServerIndex + 1) % this.servers.size();
        return server;
    }

    public static void main(String[] stringArray) {
        ArrayList<Server> arrayList = new ArrayList<Server>();
        arrayList.add(new Server("Server 1"));
        arrayList.add(new Server("Server 2"));
        arrayList.add(new Server("Server 3"));
        LoadBalancer loadBalancer = new LoadBalancer(arrayList);
        for (int i = 0; i < 7; ++i) {
            Server server = loadBalancer.getAvailableServer();
            System.out.println("Available server: " + server.getName());
        }
    }
}
