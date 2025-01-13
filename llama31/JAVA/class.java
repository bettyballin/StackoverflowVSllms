import java.util.Deque;
import java.util.LinkedList;

// Define a simple LRUUrlCache class
class LRUUrlCache {
    private final int capacity;
    private final Deque<String> urlList;

    public LRUUrlCache(int capacity) {
        this.capacity = capacity;
        this.urlList = new LinkedList<>();
    }

    public void addUrl(String url) {
        if (urlList.contains(url)) {
            urlList.remove(url); // Remove the URL if it already exists to update its position
        } else if (urlList.size() == capacity) {
            urlList.removeLast(); // Remove the least recently used URL if at capacity
        }
        urlList.addFirst(url); // Add the new URL to the front
    }

    // Added a method to print the URLs for demonstration
    public void printUrls() {
        System.out.println("Cached URLs: " + urlList);
    }

    public static void main(String[] args) {
        LRUUrlCache cache = new LRUUrlCache(10); // maintain a list of the last 10 visited URLs

        cache.addUrl("https://example.com");
        cache.addUrl("https://example.org");
        // For demonstration
        cache.printUrls();

        // Add more URLs to test LRU functionality
        cache.addUrl("https://example.net");
        cache.printUrls();
    }
}