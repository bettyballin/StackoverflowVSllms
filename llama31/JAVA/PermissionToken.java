import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.List;

// Using JWT as an example
public class PermissionToken {
    private String generateToken(String userId, List<String> permissions) {
        // Generate a JWT token containing the user's permissions
        String token = Jwts.builder()
                .setSubject(userId)
                .claim("permissions", permissions)
                .signWith(SignatureAlgorithm.HS256, "secretKey")
                .compact();
        return token;
    }

    public List<String> getUserPermissions(String token) {
        // Verify the token and extract the permissions
        Jws<Claims> claims = Jwts.parser().setSigningKey("secretKey").parseClaimsJws(token);
        List<String> permissions = (List<String>) claims.getBody().get("permissions");
        return permissions;
    }

    public static void main(String[] args) {
        PermissionToken permissionToken = new PermissionToken();
        // Example usage:
        // String token = permissionToken.generateToken("userId", Arrays.asList("permission1", "permission2"));
        // List<String> permissions = permissionToken.getUserPermissions(token);
    }
}