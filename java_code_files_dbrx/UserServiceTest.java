import java.lang.String;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext*.xml")
public class UserServiceTest {
    @Autowired
    private WebApplicationContext context;
    private SecurityContext securityContext;

    protected void setUp() throws Exception {
        // ...
        Authentication auth = new UsernamePasswordAuthenticationToken("testUser", "password");
        SecurityContextImpl securityContextImpl = new SecurityContextImpl();
        securityContextImpl.setAuthentication(auth);
        this.securityContext = securityContextImpl;
    }

    public static void main(String[] args) {
    }
}