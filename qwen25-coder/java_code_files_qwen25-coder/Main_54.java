public class Main {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.keyStore", "new_cert.p12");
        System.setProperty("javax.net.ssl.keyStorePassword", "newpass");
        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12"); // Confirming the type here.
    }
}