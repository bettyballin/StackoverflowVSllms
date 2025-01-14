public class VirusScanner {
    // Example of integrating ClamAV with Java using clamav-java

    public static void main(String[] args) {
        String filePath = args[0];
        ClamScanner scanner = new ClamScanner("localhost", 3310);
        boolean cleanFile = scanner.scanFile(filePath);
        if (!cleanFile) {
            throw new SecurityException("File contains virus");
        }
    }
}