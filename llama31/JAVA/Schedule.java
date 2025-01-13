import java.util.Date;

// Define ApplicationException class
class ApplicationException extends RuntimeException {
    public ApplicationException() {
        super("Invalid Schedule data");
    }
}

public class Schedule {
    private int locationNum;
    private int cost;
    private String costReason;
    private Date weekOfChange;
    private Date dayOfChange;
    private String changeReason;

    public Schedule(int locationNum, int cost, String costReason, Date weekOfChange, Date dayOfChange, String changeReason) {
        this.locationNum = locationNum;
        this.cost = cost;
        this.costReason = costReason;
        this.weekOfChange = weekOfChange;
        this.dayOfChange = dayOfChange;
        this.changeReason = changeReason;

        // Invariant checks
        if ((weekOfChange != null && dayOfChange != null && changeReason != null) || 
            (weekOfChange == null && dayOfChange == null && changeReason == null)) {
            // Valid data
        } else {
            throw new ApplicationException();
        }
    }

    // Getters and setters
    public int getLocationNum() {
        return locationNum;
    }

    public void setLocationNum(int locationNum) {
        this.locationNum = locationNum;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCostReason() {
        return costReason;
    }

    public void setCostReason(String costReason) {
        this.costReason = costReason;
    }

    public Date getWeekOfChange() {
        return weekOfChange;
    }

    public void setWeekOfChange(Date weekOfChange) {
        this.weekOfChange = weekOfChange;
    }

    public Date getDayOfChange() {
        return dayOfChange;
    }

    public void setDayOfChange(Date dayOfChange) {
        this.dayOfChange = dayOfChange;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }
}

class ScheduleValidator {
    // Context-dependent checks
    public void validate(Schedule schedule) {
        // Check locationNum against database
        // Check changeReason against database codes
        // ...
    }

    public static void main(String[] args) {
        Schedule schedule = new Schedule(1, 100, "Test", new Date(), new Date(), "Reason");
        ScheduleValidator validator = new ScheduleValidator();
        validator.validate(schedule);
    }
}