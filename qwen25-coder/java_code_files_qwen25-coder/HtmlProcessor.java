import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class HtmlProcessor implements Runnable {
    private final String htmlContent;

    public HtmlProcessor(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    @Override
    public void run() {
        // Create a new HtmlCleaner instance per thread
        HtmlCleaner cleaner = new HtmlCleaner();
        TagNode node = cleaner.clean(htmlContent);
        
        // Process the node
        processNode(node);
    }

    private void processNode(TagNode node) {
        // Example processing logic
        System.out.println("Processing node: " + node.getName());
    }

    public static void main(String[] args) {
        // Example usage
        String html = "<html><body><h1>Hello, World!</h1></body></html>";
        HtmlProcessor processor = new HtmlProcessor(html);
        processor.run();
    }
}