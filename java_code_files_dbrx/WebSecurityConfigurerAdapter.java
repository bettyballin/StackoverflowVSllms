import java.lang.String;
public class WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests().antMatchers("/").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }

    public static void main(String[] args) {
    }
}

class HttpSecurity {
    public CsrfConfigurer csrf() {
        return new CsrfConfigurer(this);
    }

    public ExpressionUrlAuthorizationConfigurer authorizeRequests() {
        return new ExpressionUrlAuthorizationConfigurer(this);
    }

    public HttpSecurity httpBasic() {
        return this;
    }
}

class CsrfConfigurer {
    private HttpSecurity http;

    public CsrfConfigurer(HttpSecurity http) {
        this.http = http;
    }

    public HttpSecurity disable() {
        return http;
    }
}

class ExpressionUrlAuthorizationConfigurer {
    private HttpSecurity http;

    public ExpressionUrlAuthorizationConfigurer(HttpSecurity http) {
        this.http = http;
    }

    public ExpressionUrlAuthorizationConfigurer antMatchers(String pattern) {
        return this;
    }

    public ExpressionUrlAuthorizationConfigurer permitAll() {
        return this;
    }

    public ExpressionUrlAuthorizationConfigurer anyRequest() {
        return this;
    }

    public ExpressionUrlAuthorizationConfigurer authenticated() {
        return this;
    }

    public HttpSecurity and() {
        return http;
    }
}