import java.util.Date;
import java.util.Arrays;

// Schedule.java (Domain Model)
public class Schedule {
    private int locationNum;
    private int cost;
    private String costReason;
    private Date weekOfChange;
    private Date dayOfChange;
    private String changeReason;

    // Constructors, getters, and setters

    public Schedule(int locationNum, Date weekOfChange, Date dayOfChange, String changeReason, int cost) {
        if (cost == 0 && (weekOfChange != null || dayOfChange != null || changeReason != null)) {
            throw new IllegalArgumentException("Cost must be non-zero with reason");
        }
        this.locationNum = locationNum;
        this.weekOfChange = weekOfChange;
        this.dayOfChange = dayOfChange;
        this.changeReason = changeReason;
        this.cost = cost;
    }

    public void updateChange(Date weekOfChange, Date dayOfChange, String reason) {
        if (weekOfChange == null || dayOfChange == null || reason == null) {
            throw new IllegalArgumentException("Invalid change parameters");
        }
        this.weekOfChange = weekOfChange;
        this.dayOfChange = dayOfChange;
        this.changeReason = reason;
    }

    public int getLocationNum() {
        return locationNum;
    }

    public String getChangeReason() {
        return changeReason;
    }
}

// ScheduleValidator.java (Business Layer)
class ScheduleValidator {
    private LocationDAO locationDAO; // Assume you have a DAO for locations

    public ScheduleValidator() {
        this.locationDAO = new LocationDAO();
    }

    public void validate(Schedule schedule) throws ApplicationException {
        if (!locationDAO.isValidLocation(schedule.getLocationNum())) {
            throw new InvalidLocationException("Invalid location number");
        }
        if (!isValidChangeReason(schedule.getChangeReason())) {
            throw new InvalidReasonException("Invalid change reason");
        }
        // More business rules...
    }

    private boolean isValidChangeReason(String reason) {
        // Check against valid reasons
        return Arrays.asList("REASON1", "REASON2", "REASON3").contains(reason);
    }
}

// Assume definitions for ApplicationException, InvalidLocationException, InvalidReasonException, LocationDAO
class ApplicationException extends Exception {
    public ApplicationException(String message) {
        super(message);
    }
}

class InvalidLocationException extends ApplicationException {
    public InvalidLocationException(String message) {
        super(message);
    }
}

class InvalidReasonException extends ApplicationException {
    public InvalidReasonException(String message) {
        super(message);
    }
}

class LocationDAO {
    public boolean isValidLocation(int locationNum) {
        // For the purpose of this example, assume all locationNums are valid
        return true;
    }
}

// When loading from database
public class MainClass {
    public Schedule loadSchedule(int id) throws ApplicationException {
        // Load data into fields (simulated here)
        int locationNum = 1;
        Date weekOfChange = new Date();
        Date dayOfChange = new Date();
        String changeReason = "REASON1";
        int cost = 100;

        Schedule schedule = new Schedule(locationNum, weekOfChange, dayOfChange, changeReason, cost);
        new ScheduleValidator().validate(schedule); // Validate after creation
        return schedule;
    }

    public static void main(String[] args) {
        MainClass app = new MainClass();
        try {
            Schedule schedule = app.loadSchedule(1);
            System.out.println("Schedule loaded and validated successfully.");
        } catch (ApplicationException e) {
            System.err.println("Error loading schedule: " + e.getMessage());
        }
    }
}