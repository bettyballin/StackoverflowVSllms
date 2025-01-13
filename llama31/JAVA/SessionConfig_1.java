import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.session.web.http.CookieHttpSessionStrategy;

public class SessionConfig_1_1 {
    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setUseSecureCookie(false);
        serializer.setCookieName("JSESSIONID");
        serializer.setCookiePath("/");
        serializer.setCookieDomain("");
        serializer.setCookieHttpOnly(true);
        serializer.setCookieSecure(false);
        serializer.setCookieMaxAge(-1);
        return serializer;
    }

    @Bean
    public CookieHttpSessionStrategy cookieHttpSessionStrategy() {
        CookieHttpSessionStrategy strategy = new CookieHttpSessionStrategy();
        strategy.setCookieSerializer(cookieSerializer());
        return strategy;
    }

    public static void main(String[] args) {
    }
}