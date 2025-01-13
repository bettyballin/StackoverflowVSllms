import java.util.HashMap;

public class SynchronizedMapAccessor {
    private HashMap<Integer, Object> map = new HashMap<>();

    public synchronized void myPut(int something) {
        // some other logic here
        this.map.put(something, null);
        // some other logic here
    }

    public static void main(String[] args) {
        SynchronizedMapAccessor accessor = new SynchronizedMapAccessor();
        accessor.myPut(1);
    }
}