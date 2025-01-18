import java.lang.String;

public class LicenseChecker {
    public static final long LICENCE_VALIDITY = 24 * 60 * 60 * 1000; // one day in milliseconds.
    private Long lastCheckedTime;
    private boolean isLicenceValid() { /* Check against your conditions */ throw new UnsupportedOperationException("Not implemented yet"); }

    public synchronized void checkLicense() throws LicenseException{
        long currentTime = System.currentTimeMillis();
        if(lastCheckedTime == null || (currentTime - lastCheckedTime) > LICENCE_VALIDITY){
            if(!isLicenceValid()) throw new LicenseException("Invalid license");
            lastCheckedTime = currentTime;
        }
    }

    public static void main(String[] args) {
    }

    public static class LicenseException extends Exception {
        public LicenseException() {
            super();
        }

        public LicenseException(String message) {
            super(message);
        }

        public LicenseException(String message, Throwable cause) {
            super(message, cause);
        }

        public LicenseException(Throwable cause) {
            super(cause);
        }
    }
}