public class ContentConnectionAdditiveInfo {

    private Content fromContent;
    private Content toContent;
    private Integer connectionTypeId;
    private Integer fromContentTypeId;
    private Integer toContentTypeId;

    // Getters and Setters ...

    public Content getFromContent() {
        return fromContent;
    }

    public void setFromContent(Content fromContent) {
        this.fromContent = fromContent;
    }

    public Content getToContent() {
        return toContent;
    }

    public void setToContent(Content toContent) {
        this.toContent = toContent;
    }

    public Integer getConnectionTypeId() {
        return connectionTypeId;
    }

    public void setConnectionTypeId(Integer connectionTypeId) {
        this.connectionTypeId = connectionTypeId;
    }

    public Integer getFromContentTypeId() {
        return fromContentTypeId;
    }

    public void setFromContentTypeId(Integer fromContentTypeId) {
        this.fromContentTypeId = fromContentTypeId;
    }

    public Integer getToContentTypeId() {
        return toContentTypeId;
    }

    public void setToContentTypeId(Integer toContentTypeId) {
        this.toContentTypeId = toContentTypeId;
    }

    public static void main(String[] args) {
    }
}

class Content {
    // Simple Content class to enable compilation
}