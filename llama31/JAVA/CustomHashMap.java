import java.util.HashMap;

public class CustomHashMap {
    private HashMap<Integer, Object> map;

    public CustomHashMap() {
        this.map = new HashMap<>();
    }

    public void myPut(int something) {
        // some other logic here
        this.map.put(something, null);
        // some other logic here
    }

    public static void main(String[] args) {
        CustomHashMap customHashMap = new CustomHashMap();
        customHashMap.myPut(1);
    }
}