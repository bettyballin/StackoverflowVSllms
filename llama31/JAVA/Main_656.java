import org.htmlcompressor.HtmlCompressor;

public class Main_656 {
    public static void main(String[] args) {
        HtmlCompressor compressor = new HtmlCompressor();
        String html = "<html>...</html>";
        String minifiedHtml = compressor.compress(html);
        System.out.println(minifiedHtml);
    }
}