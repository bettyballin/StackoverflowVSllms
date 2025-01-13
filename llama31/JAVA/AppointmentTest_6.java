import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppointmentTest_6_6 {

    @Test
    public void createSingleAppointment() {
        Appointment appointment = new Appointment("Single Appointment");
        assertTrue(appointment != null);
    }

    @Test
    public void createWeeklyRecurringAppointment() {
        Appointment appointment = new Appointment("Weekly Recurring Appointment", Recurrence.WEEKLY);
        assertTrue(appointment != null);
    }

    @Test
    public void createMonthlyRecurringAppointment() {
        Appointment appointment = new Appointment("Monthly Recurring Appointment", Recurrence.MONTHLY);
        assertTrue(appointment != null);
    }

    @Test
    public void createEvery2WeeksRecurringAppointment() {
        Appointment appointment = new Appointment("Every 2 Weeks Recurring Appointment", Recurrence.EVERY_2_WEEKS);
        assertTrue(appointment != null);
    }

    @Test
    public void createEvery2MonthsRecurringAppointment() {
        Appointment appointment = new Appointment("Every 2 Months Recurring Appointment", Recurrence.EVERY_2_MONTHS);
        assertTrue(appointment != null);
    }

    @Test
    public void createAnnualRecurringAppointment() {
        Appointment appointment = new Appointment("Annual Recurring Appointment", Recurrence.ANNUAL);
        assertTrue(appointment != null);
    }

    public enum Recurrence {
        WEEKLY,
        MONTHLY,
        EVERY_2_WEEKS,
        EVERY_2_MONTHS,
        ANNUAL
    }

    public static class Appointment {
        private String name;
        private Recurrence recurrence;

        public Appointment(String name) {
            this.name = name;
        }

        public Appointment(String name, Recurrence recurrence) {
            this.name = name;
            this.recurrence = recurrence;
        }

        public String getName() {
            return name;
        }

        public Recurrence getRecurrence() {
            return recurrence;
        }
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("AppointmentTest_6");
    }
}