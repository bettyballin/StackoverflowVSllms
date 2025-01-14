public class TrustStoreSetup {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore", "mytruststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        System.setProperty("javax.net.ssl.trustStoreType", "JKS"); // Use JKS if you converted it to a JKS store
    }
}