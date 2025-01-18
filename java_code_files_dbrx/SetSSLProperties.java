public class SetSSLProperties {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.keyStore", "<path_to_your_keystore_file>"); // path to your keystore pkcs12 file.
        System.setProperty("javax.net.ssl.keyStorePassword", "<password>"); // password for the client certificate(s) in keyStore
    }
}