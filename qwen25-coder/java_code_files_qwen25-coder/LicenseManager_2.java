import java.lang.String;
import org.springframework.stereotype.Component;
import java.util.concurrent.Semaphore;

@Component
public class LicenseManager_2 {
    private final Semaphore semaphore;

    public LicenseManager_2(int numberOfLicenses) {
        // Initialize semaphore with the number of licenses available
        this.semaphore = new Semaphore(numberOfLicenses, true);
    }

    public boolean acquireLicense() throws InterruptedException {
        return semaphore.tryAcquire();
    }

    public void releaseLicense() {
        semaphore.release();
    }

    public static void main(String[] args) {
    }
}