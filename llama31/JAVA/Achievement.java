// Define the @Embedded annotation
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Embedded {}

// Define the @AttributeOverride annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface AttributeOverride {
    String name();
    Column column();
}

// Define the @Column annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

// Define the BaseDomainObject class
class BaseDomainObject {}

// Define the ContentID class
class ContentID {}

public class Achievement extends BaseDomainObject {

    @Embedded
    @AttributeOverride(name = "contentID", column = @Column(name = "awardedItem"))
    private ContentID awardedItem;

    public static void main(String[] args) {}
}