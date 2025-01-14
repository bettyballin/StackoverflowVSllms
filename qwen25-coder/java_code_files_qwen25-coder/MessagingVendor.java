import java.lang.String;
public class MessagingVendor {
    private String name;
    private int performanceScore; // 1-10 scale
    private int availabilityScore; // 1-10 scale
    private int scalabilityScore; // 1-10 scale
    private int securityScore; // 1-10 scale
    private int integrationScore; // 1-10 scale
    private int reliabilityScore; // 1-10 scale
    private int complianceScore; // 1-10 scale
    private int privacyScore; // 1-10 scale
    private int costEfficiencyScore; // 1-10 scale
    private int supportDocumentationScore; // 1-10 scale

    public MessagingVendor(String name) {
        this.name = name;
    }

    // Getters and setters for each score...

    public double calculateOverallScore() {
        return (performanceScore + availabilityScore + scalabilityScore + securityScore +
                integrationScore + reliabilityScore + complianceScore + privacyScore +
                costEfficiencyScore + supportDocumentationScore) / 10.0;
    }

    // Other methods...

	public static void main(String[] args) {
	}
}