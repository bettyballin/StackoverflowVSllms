import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

public class Achievement_1_1 extends BaseDomainObject {

    @OneToOne
    @JoinColumn(name = "awardedItem")
    private ContentID awardedItem;

    public static void main(String[] args) {
    }
}

class BaseDomainObject {
    // Add implementation for BaseDomainObject class
}

class ContentID {
    // Add implementation for ContentID class
}