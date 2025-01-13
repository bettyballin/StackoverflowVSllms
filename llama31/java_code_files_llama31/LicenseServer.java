/*
 * Decompiled with CFR 0.152.
 */
public class LicenseServer {
    public License issueLicense(ClientRequest clientRequest) {
        if (this.validateClient(clientRequest)) {
            License license = this.generateLicense(clientRequest);
            return license;
        }
        return null;
    }

    private boolean validateClient(ClientRequest clientRequest) {
        return true;
    }

    private License generateLicense(ClientRequest clientRequest) {
        return new License();
    }

    public static void main(String[] stringArray) {
        LicenseServer licenseServer = new LicenseServer();
        ClientRequest clientRequest = new ClientRequest();
        License license = licenseServer.issueLicense(clientRequest);
        System.out.println(license);
    }
}
