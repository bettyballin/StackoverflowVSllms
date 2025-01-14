// Example Java code for conflict resolution
public class ConflictResolver {

    // Checksums for the systems
    private int oracleChecksum;
    private int peoplesoftChecksum;
    private int siebelChecksum;

    public static void main(String[] args) {
        ConflictResolver resolver = new ConflictResolver();
        resolver.checkSystems();
    }

    public void checkSystems() {
        // Initialize checksums (example values)
        oracleChecksum = getChecksumFromOracle();
        peoplesoftChecksum = getChecksumFromPeopleSoft();
        siebelChecksum = getChecksumFromSiebel();

        if (oracleChecksum != peoplesoftChecksum) {
            resolveConflict("Oracle", "PeopleSoft");
        } else if (oracleChecksum != siebelChecksum) {
            resolveConflict("Oracle", "Siebel");
        }
    }

    private void resolveConflict(String primarySystem, String secondarySystem) {
        // Logic to update secondary system or flag discrepancy
        System.out.println("Resolving conflict between " + primarySystem + " and " + secondarySystem);
    }

    // Methods to simulate fetching checksums from different systems
    private int getChecksumFromOracle() {
        // Logic to get checksum from Oracle
        return 100; // Example value
    }

    private int getChecksumFromPeopleSoft() {
        // Logic to get checksum from PeopleSoft
        return 200; // Example value
    }

    private int getChecksumFromSiebel() {
        // Logic to get checksum from Siebel
        return 100; // Example value
    }
}