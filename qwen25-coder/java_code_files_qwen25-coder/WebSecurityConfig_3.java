import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import static org.springframework.security.saml.SAMLConfigurer.saml;
import org.springframework.security.saml.SAMLConfigurer;
import org.springframework.security.saml.SAMLLogoutProcessingFilter;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.cas.ServiceProperties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig_3 extends WebSecurityConfigurerAdapter {

    @Autowired
    private HttpServletRequest request;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic().disable()
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/saml/**").permitAll()  // SAML Endpoints are public
                .anyRequest().authenticated()       // Require authentication for other requests
            .and().apply(saml())
                .serviceProvider()
                    .keyStore()
                        .storeFilePath("classpath:samlKeystore.jks")
                        .password("password")
                        .keyname("apollo")
                        .keyPassword("password")
                    .and()
                        .protocol("https")
                        .hostname(String.format("%s://%s:%d",
                            request.getScheme(),
                            request.getServerName(),
                            request.getServerPort()))
                        .basePath("/")
                        .entityId("your-entity-id")
                        .metadataLocation("classpath:sp.xml")   // Metadata of the SP
                .and().identityProvider()
                    .metadataFilePath("classpath:idp.xml");  // Metadata of the IdP
    }

    @Bean
    public FilterChainProxy samlFilter() throws Exception {
        List<Filter> filters = new ArrayList<>();
        filters.add(new SAMLLogoutProcessingFilter(
            new AntPathRequestMatcher("/saml/logout"),
            successLogoutHandler()));
        LogoutHandler logoutHandler = http().getSharedObject(LogoutHandler.class);
        return new FilterChainProxy(filters);
    }

    private ServiceProperties serviceProperties() {
        ServiceProperties serviceProperties = new ServiceProperties();
        serviceProperties.setService("https://app.com/saml/SSO");
        serviceProperties.setAuthenticateAllArtifacts(false);
        return serviceProperties;
    }

    private LogoutSuccessHandler successLogoutHandler() {
        SimpleUrlLogoutSuccessHandler handler = new SimpleUrlLogoutSuccessHandler();
        handler.setDefaultTargetUrl("/");
        return handler;
    }

    public static void main(String[] args) {
    }
}