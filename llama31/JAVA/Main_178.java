import org.glassfish.embeddable.GlassFishProperties;

public class Main_178 {
    public static void main(String[] args) {
        GlassFishProperties glassFishProperties = new GlassFishProperties();
        glassFishProperties.setTrustStore("glassfish-keystore.jks");
        glassFishProperties.setTrustStorePassword("your-keystore-password");
    }
}