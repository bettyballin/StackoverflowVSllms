import java.lang.String;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

public class ConfigDaoProvider {
    @Produces
    @RequestScoped
    public MyDao myDao() {
        return new MyDao();
    }

    public static void main(String[] args) {
    }
}