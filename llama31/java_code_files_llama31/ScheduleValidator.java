/*
 * Decompiled with CFR 0.152.
 */
import java.util.Date;

class ScheduleValidator {
    ScheduleValidator() {
    }

    public void validate(Schedule schedule) {
    }

    public static void main(String[] stringArray) {
        Schedule schedule = new Schedule(1, 100, "Test", new Date(), new Date(), "Reason");
        ScheduleValidator scheduleValidator = new ScheduleValidator();
        scheduleValidator.validate(schedule);
    }
}
