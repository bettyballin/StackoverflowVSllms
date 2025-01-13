import org.htmlcleaner.HtmlCleaner;

public class ThreadSafeHtmlCleaner {
    private final HtmlCleaner cleaner;

    public ThreadSafeHtmlCleaner() {
        cleaner = new HtmlCleaner();
    }

    public synchronized String cleanHtml(String html) {
        return cleaner.clean(html).toString();
    }

    public static void main(String[] args) {
        ThreadSafeHtmlCleaner cleaner = new ThreadSafeHtmlCleaner();
        String html = "<p>Hello, <b>World!</b></p>";
        String cleanedHtml = cleaner.cleanHtml(html);
        System.out.println(cleanedHtml);
    }
}