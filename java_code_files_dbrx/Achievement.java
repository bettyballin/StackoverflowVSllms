import java.lang.String;
import javax.persistence.Embedded;
import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;

public class Achievement extends BaseDomainObject {
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="contentID", column = @Column(name="awardedItem", insertable=false, updatable=false) )
    })
    private ContentID awardedItem;

    public static void main(String[] args) {
    }
}

class BaseDomainObject {
}

class ContentID {
}