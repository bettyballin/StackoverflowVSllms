public class MyClass {
    public static void main(String[] args) {
        try {
            // make request using old token here.
        } catch (FacebookAuthorizationException e) {
            Session session = getNewSession(); 
            /* Obtain a new, non-expired session object.
               You can use Facebook SDK for Android to do this easily by calling the authorize method with your desired permissions:
               Session.openActiveSessionWithPermissions(this, Arrays.asList("basic_info", "publish_actions"), ...) */

            /* Resume your request using new token here: just call whatever you were doing previously but pass in the session object containing the new access token.
               Your previous call should look similar to this (just replace SESSION with the parameter that Session uses for requests, which depends on what SDK/API client library you are using): */

            // makeRequest(SESSION);
        }
    }
    
    // Placeholder method to satisfy the compiler
    public static Session getNewSession() {
        return new Session();
    }
}

// Placeholder classes to satisfy the compiler
class FacebookAuthorizationException extends Exception {}
class Session {}