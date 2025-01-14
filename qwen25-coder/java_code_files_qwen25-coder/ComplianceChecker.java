import java.lang.String;
public class ComplianceChecker {
    private boolean isPersonalData;
    private boolean hasConsent;
    private boolean dataResidentInEU;

    public ComplianceChecker(boolean isPersonalData, boolean hasConsent, boolean dataResidentInEU) {
        this.isPersonalData = isPersonalData;
        this.hasConsent = hasConsent;
        this.dataResidentInEU = dataResidentInEU;
    }

    // Check GDPR compliance based on parameters
    public boolean checkGDPRCompliance() {
        if (isPersonalData && !hasConsent) {
            System.out.println("Non-compliant: Consent is required for processing personal data.");
            return false;
        }
        if (dataResidentInEU) {
            // Additional checks could be done here specific to GDPR for EU-resident data
            System.out.println("Compliance Note: Ensure adherence to GDPR standards for EU-resident data.");
        }
        return true;
    }

    public static void main(String[] args) {
        ComplianceChecker complianceChecker = new ComplianceChecker(true, true, true);
        boolean isCompliant = complianceChecker.checkGDPRCompliance();
        System.out.println("Is the service GDPR compliant? " + isCompliant);
    }
}