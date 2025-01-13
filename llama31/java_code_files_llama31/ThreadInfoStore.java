/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class ThreadInfoStore {
    private HashMap<Integer, InfoForTheThread> threadInfoMap = new HashMap();

    public void addThreadInfo(int n, InfoForTheThread infoForTheThread) {
        this.threadInfoMap.put(n, infoForTheThread);
    }

    public InfoForTheThread getThreadInfo(int n) {
        return this.threadInfoMap.get(n);
    }

    public void removeThreadInfo(int n) {
        this.threadInfoMap.remove(n);
    }

    public static void main(String[] stringArray) {
    }
}
