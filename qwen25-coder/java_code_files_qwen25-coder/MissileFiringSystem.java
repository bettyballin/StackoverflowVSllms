import java.util.ArrayList;
import java.util.List;

public class MissileFiringSystem {

    private ValidationService validationService = new ValidationService();

    public void fireMissiles(MissileParameters parameters) throws ValidationException {
        List<String> errors = validationService.validate(parameters);
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
        // Fire the missiles
    }

    // GUI can use this method to validate input before firing
    public List<String> validateInput(MissileParameters parameters) {
        return validationService.validate(parameters);
    }
}

class MissileParameters {
    private String target;
    private double latitude;
    private double longitude;

    // Getters and setters
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

class ValidationService {

    public List<String> validate(MissileParameters parameters) {
        List<String> errors = new ArrayList<>();
        if (parameters.getTarget() == null || parameters.getTarget().isEmpty()) {
            errors.add("Target not specified.");
        }
        if (parameters.getLatitude() < -90 || parameters.getLatitude() > 90) {
            errors.add("Invalid latitude.");
        }
        if (parameters.getLongitude() < -180 || parameters.getLongitude() > 180) {
            errors.add("Invalid longitude.");
        }
        // Add more validation rules

        return errors;
    }
}

class ValidationException extends Exception {
    private List<String> errorMessages;

    public ValidationException(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public static void main(String[] args) {
    }
}