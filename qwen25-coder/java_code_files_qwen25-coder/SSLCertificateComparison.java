import java.lang.String;
public class SSLCertificateComparison {
    public static void main(String[] args) {
        Certificate rapidSSL = new Certificate("RapidSSL", 69, "Basic SSL", false);
        Certificate geoTrust = new Certificate("GeoTrust", 249, "Professional Level SSL with EV options", true);

        System.out.println(rapidSSL.toString());
        System.out.println(geoTrust.toString());

        if (geoTrust.getPrice() > rapidSSL.getPrice()) {
            System.out.println("GeoTrust is more expensive due to additional features and brand trust.");
        }
    }
}

class Certificate {
    private String name;
    private int price; // in dollars
    private String description;
    private boolean supportsEV;

    public Certificate(String name, int price, String description, boolean supportsEV) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.supportsEV = supportsEV;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getDescription() { return description; }
    public boolean supportsExtendedValidation() { return supportsEV; }

    @Override
    public String toString() {
        return "Certificate{" +
                "name='" + name + '\'' +
                ", price=$" + price +
                ", description='" + description + '\'' +
                ", supportsEV=" + supportsEV +
                '}';
    }
}