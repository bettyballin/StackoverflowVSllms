public class ServerClassArrayFactory {
    public ServerClass[] getObjectArray() {
        ServerClass s1 = new ServerClass(1, "object 1");
        ServerClass s2 = new ServerClass(2, "object 2");
        // ...
        return new ServerClass[]{s1, s2}; // Return array of objects.
    }

    public static void main(String[] args) {
    }
}

class ServerClass {
    int id;
    String name;

    public ServerClass(int id, String name) {
        this.id = id;
        this.name = name;
    }
}