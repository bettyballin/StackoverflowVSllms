public class CookieManager {
    public static void main(String[] args) {
        Response response = new Response();
        response.addHeader("Set-Cookie", "sessionid=38afes7a8; Secure; HttpOnly");
    }

    static class Response {
        public void addHeader(String name, String value) {
            // Simulate adding a header
            System.out.println("Added header: " + name + " = " + value);
        }
    }
}