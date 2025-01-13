import java.util.HashMap;

class InfoForTheThread {
    // Add fields and methods as needed for this class
}

public class ThreadInfoStore {
    private HashMap<Integer, InfoForTheThread> threadInfoMap = new HashMap<>();

    public void addThreadInfo(int threadId, InfoForTheThread info) {
        threadInfoMap.put(threadId, info);
    }

    public InfoForTheThread getThreadInfo(int threadId) {
        return threadInfoMap.get(threadId);
    }

    public void removeThreadInfo(int threadId) {
        threadInfoMap.remove(threadId);
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}