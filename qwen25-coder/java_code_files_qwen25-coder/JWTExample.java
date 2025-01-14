import java.lang.String;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;

import java.util.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.NoSuchAlgorithmException;

public class JWTExample {

    private static PrivateKey privateKey;
    private static PublicKey publicKey;

    static {
        KeyPair keyPair = generateKeyPair();
        privateKey = keyPair.getPrivate();
        publicKey = keyPair.getPublic();
    }

    private static KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            return keyGen.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateJWT(String username) {
        Instant now = Instant.now();
        return Jwts.builder()
                .setSubject(username)
                .claim("scope", "read:messages write:messages")
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(1, ChronoUnit.HOURS)))
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }

    public static Claims verifyJWT(String jwt) {
        return Jwts.parserBuilder()
                   .setSigningKey(publicKey)
                   .build()
                   .parseClaimsJws(jwt).getBody();
    }

    public static void main(String[] args) {
    }
}