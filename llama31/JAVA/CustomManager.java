// Since we can't use StandardManager directly, we'll create a simplified version for this example
class StandardManager {
    public int getSessionIdLength() {
        return 16; // A default value for demonstration
    }
}

public class CustomManager extends StandardManager {
    @Override
    public int getSessionIdLength() {
        return 20;
    }

    public static void main(String[] args) {
        CustomManager customManager = new CustomManager();
        System.out.println("Custom Session ID Length: " + customManager.getSessionIdLength());
    }
}