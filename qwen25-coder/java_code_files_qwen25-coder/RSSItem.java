import java.lang.String;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Attribute;

@Root(name = "item", strict = false)
public class RSSItem {

    @Namespace(reference = "http://search.yahoo.com/mrss/")
    @Element(required = false, name = "thumbnail")
    private MediaThumbnail thumbnail;

    // Getters and setters
    public MediaThumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(MediaThumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }
}

class MediaThumbnail {

    @Attribute(name = "url")
    private String url;

    // Getters and setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static void main(String[] args) {
    }
}