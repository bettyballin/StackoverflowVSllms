import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class ContentID implements Serializable {

    @Column(name = "contentPath")
    private String contentPath;

    // getters and setters
    public String getContentPath() {
        return contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }
}

@MappedSuperclass
public abstract class BaseDomainObject implements Serializable {

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "contentPath", column = @Column(name = "baseContentID"))
    })
    private ContentID contentID;

    // getters and setters
    public ContentID getContentID() {
        return contentID;
    }

    public void setContentID(ContentID contentID) {
        this.contentID = contentID;
    }
}

@Entity
public class Achievement extends BaseDomainObject {

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "contentPath", column = @Column(name = "awardedItem"))
    })
    private ContentID awardedItem;

    // getters and setters
    public ContentID getAwardedItem() {
        return awardedItem;
    }

    public void setAwardedItem(ContentID awardedItem) {
        this.awardedItem = awardedItem;
    }

    public static void main(String[] args) {
        // You can test your code here
    }
}