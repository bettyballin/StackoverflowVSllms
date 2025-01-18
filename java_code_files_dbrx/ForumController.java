import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface ManagedBean {
    String name() default "";
}

@ManagedBean(name = "forumController")
public class ForumController {

    // Assuming you have a Service and DAO layer to manage persistence,
    private ForumService forumService = new ForumService();

    public String getTitle() {
        // Return title fetched from db (via services or directly)
        return forumService.getTitleOfLatestMessage();
    }
}

class ForumService {
    public String getTitleOfLatestMessage() {
        return "Latest message title";
    }
}