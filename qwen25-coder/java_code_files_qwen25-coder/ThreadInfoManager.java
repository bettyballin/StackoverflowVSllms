import java.util.HashMap;

public class ThreadInfoManager {
    private HashMap<Integer, InfoForTheThread> map = new HashMap<>();

    public void addInfo(int threadId, InfoForTheThread info) {
        map.put(threadId, info);
    }

    public InfoForTheThread getInfo(int threadId) {
        return map.get(threadId);
    }

    public void removeInfo(int threadId) {
        map.remove(threadId);
    }

    public static void main(String[] args) {
    }
}

class InfoForTheThread {
    // Minimal implementation to make the code compile
}