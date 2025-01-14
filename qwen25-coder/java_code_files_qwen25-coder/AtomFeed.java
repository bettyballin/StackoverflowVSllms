import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "feed")
public class AtomFeed {
    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "link")
    private Link link;

    // getters and setters...

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
}

class Link {
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public static void main(String[] args) {
    }
}