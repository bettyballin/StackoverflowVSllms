public class UserSessionManager {

    private UserService userService = new UserService();
    private TokenService tokenService = new TokenService();

    public void loginUser(String username, boolean rememberMe) {
        User user = userService.findByUsername(username);
        String sessionToken = generateSessionToken(user);

        if (!rememberMe) {
            // Invalidate all previous tokens for this user
            invalidatePreviousTokensForUser(user.getId());
        }

        // Store the new token in secure storage (e.g., Redis)
        storeToken(sessionToken, user.getId());

        // Set the cookie to client-side or return it in the response
        setCookieOrReturnResponse(sessionToken);
    }

    private void invalidatePreviousTokensForUser(Long userId) {
        // Logic to invalidate all tokens for the given user ID
        tokenService.invalidateTokens(userId);
    }

    private String generateSessionToken(User user) {
        // Dummy implementation
        return "dummy_token";
    }

    private void storeToken(String token, Long userId) {
        // Dummy implementation
    }

    private void setCookieOrReturnResponse(String sessionToken) {
        // Dummy implementation
    }

    public static void main(String[] args) {
    }
}

class User {
    private Long id;
    private String username;
    // Constructor, getters, and setters

    public Long getId() {
        return id;
    }
}

class UserService {
    public User findByUsername(String username) {
        // Dummy implementation
        return new User();
    }
}

class TokenService {
    public void invalidateTokens(Long userId) {
        // Dummy implementation
    }
}