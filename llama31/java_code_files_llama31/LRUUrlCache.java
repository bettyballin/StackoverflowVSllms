/*
 * Decompiled with CFR 0.152.
 */
import java.util.Deque;
import java.util.LinkedList;

class LRUUrlCache {
    private final int capacity;
    private final Deque<String> urlList;

    public LRUUrlCache(int n) {
        this.capacity = n;
        this.urlList = new LinkedList<String>();
    }

    public void addUrl(String string) {
        if (this.urlList.contains(string)) {
            this.urlList.remove(string);
        } else if (this.urlList.size() == this.capacity) {
            this.urlList.removeLast();
        }
        this.urlList.addFirst(string);
    }

    public void printUrls() {
        System.out.println("Cached URLs: " + String.valueOf(this.urlList));
    }

    public static void main(String[] stringArray) {
        LRUUrlCache lRUUrlCache = new LRUUrlCache(10);
        lRUUrlCache.addUrl("https://example.com");
        lRUUrlCache.addUrl("https://example.org");
        lRUUrlCache.printUrls();
        lRUUrlCache.addUrl("https://example.net");
        lRUUrlCache.printUrls();
    }
}
