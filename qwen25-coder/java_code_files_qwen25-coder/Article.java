import java.nio.charset.StandardCharsets;

public class Article {
    private String srcUrl;
    private byte[] articleBlob;

    // getters and setters

    public void setArticleBlob(byte[] articleBlob) { this.articleBlob = articleBlob; }
    public byte[] getArticleBlob() { return articleBlob; }

    public String getArticle() {
        if (articleBlob != null) {
            return new String(articleBlob, StandardCharsets.UTF_8); // or the correct charset
        }
        return null;
    }

    public static void main(String[] args) {
    }
}