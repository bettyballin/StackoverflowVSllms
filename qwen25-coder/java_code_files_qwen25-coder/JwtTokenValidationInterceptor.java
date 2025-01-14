import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Priority(Priorities.AUTHENTICATION)
public class JwtTokenValidationInterceptor implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        final String token = getAuthorizationHeader(requestContext);

        if (token == null || !isTokenValid(token)) {
            abortWithUnauthorized(requestContext);
        }
    }

    private String getAuthorizationHeader(ContainerRequestContext requestContext) {
        return requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
    }

    private boolean isTokenValid(String token) {
        // Implement JWT validation logic here
        return true; // Simplified for example purposes
    }

    private void abortWithUnauthorized(ContainerRequestContext requestContext) {
        requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Authentication failed")
                        .build());
    }

    public static void main(String[] args) {
    }
}

// Definitions of missing classes and interfaces to make the code compile

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Priority {
    int value();
}

class Priorities {
    public static final int AUTHENTICATION = 1000;
}

interface ContainerRequestFilter {
    void filter(ContainerRequestContext requestContext) throws IOException;
}

interface ContainerRequestContext {
    String getHeaderString(String name);
    void abortWith(Response response);
}

class HttpHeaders {
    public static final String AUTHORIZATION = "Authorization";
}

class Response {
    public static ResponseBuilder status(Status status) {
        return new ResponseBuilder(status);
    }

    public enum Status {
        UNAUTHORIZED
    }

    public static class ResponseBuilder {
        private Status status;
        private String entity;

        public ResponseBuilder(Status status) {
            this.status = status;
        }

        public ResponseBuilder entity(String entity) {
            this.entity = entity;
            return this;
        }

        public Response build() {
            return new Response();
        }
    }
}