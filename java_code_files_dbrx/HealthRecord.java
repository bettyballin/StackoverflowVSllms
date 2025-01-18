import java.lang.String;
import java.util.logging.Logger;

public class HealthRecord {

    private static final Logger log = Logger.getLogger(HealthRecord.class.getName());
    private boolean medicalHMO;

    public void setMedicalHMO(boolean medicalHMO) {
        log.info("Setting medicalHMO property value : " + medicalHMO);
        this.medicalHMO = medicalHMO;
    }

    public static void main(String[] args) {
    }
}