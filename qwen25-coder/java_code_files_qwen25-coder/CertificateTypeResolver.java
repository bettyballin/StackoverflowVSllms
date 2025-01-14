public class CertificateTypeResolver {
    // Example pseudo-code to illustrate decision-making in a CA system

    public String getCertificateType(DomainValidationLevel level) {
        if (level == DomainValidationLevel.BASIC) {
            return "Class 1 Certificate";
        } else if (level == DomainValidationLevel.ENHANCED || level == DomainValidationLevel.EXTENDED) {
            return "Class 3 Certificate";
        }
        throw new IllegalArgumentException("Unknown validation level");
    }

    public static void main(String[] args) {
        // You can test the method here
        CertificateTypeResolver resolver = new CertificateTypeResolver();
        System.out.println(resolver.getCertificateType(DomainValidationLevel.BASIC));
        System.out.println(resolver.getCertificateType(DomainValidationLevel.ENHANCED));
        System.out.println(resolver.getCertificateType(DomainValidationLevel.EXTENDED));
    }

    enum DomainValidationLevel {
        BASIC, ENHANCED, EXTENDED;
    }
}