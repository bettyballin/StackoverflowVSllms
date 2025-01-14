import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Configuration
public class SessionConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .sessionManagement()
                .invalidSessionUrl("/login?invalid")
                .maximumSessions(1)
                    .expiredUrl("/login?expired")
                    .sessionRegistry(sessionRegistry())
                    .and()
                .and()
            .rememberMe()
                .tokenValiditySeconds(86400); // 24 hours
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<>(new HttpSessionEventPublisher());
    }
}

class CustomSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Optional: Code to execute when a session is created
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Cleanup code to delete temporary files for the session
        String userId = (String) se.getSession().getAttribute("userId");
        deleteTemporaryFiles(userId);
    }

    private void deleteTemporaryFiles(String userId) {
        // Implement logic to delete temporary files based on userId or sessionId
    }
}

@Component
class MaintenanceTasks {

    @Scheduled(fixedRate = 86400000) // Run once a day
    public void cleanupAbandonedSessions() {
        // Logic to find and delete abandoned session temporary files
        // This could involve checking timestamps or flags indicating session abandonment
    }
}