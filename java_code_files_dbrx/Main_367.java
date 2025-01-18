public class Main {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore", "/path-to-yourJDK/jre/lib/security/cacerts");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit"); // default password for cacerts
    }
}