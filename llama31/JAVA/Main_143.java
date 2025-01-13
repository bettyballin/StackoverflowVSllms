import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.ws.rs.core.Response;

public class Main_143 {
    public static void main(String[] args) {
        // Generate a JWT token upon successful authentication
        JwtBuilder builder = Jwts.builder();
        String token = builder.setSubject("user123")
                              .signWith(SignatureAlgorithm.HS256, "secretKey")
                              .compact();

        // Return the JWT token in the response
        Response response = Response.ok(token).build();
        System.out.println(response.getEntity());
    }
}