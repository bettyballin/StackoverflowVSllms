import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@ApplicationPath("api")  // URL path is /context-path/api/*
public class MyApplication_2 extends Application {
    private final Set<Class<?>> classes = new HashSet<>();

    public MyApplication_2() {
        configurations();
    }

    private void configurations() {
        this.classes.add(UserService.class);  // register service endpoint
        this.classes.add(JacksonJsonProvider.class);  // register JSON provider
    }

    public static void main(String[] args) {
    }
}