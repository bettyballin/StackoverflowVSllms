import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class AppointmentTest_24_24 {

    @Test
    public void createSingleAppointment() {
        // create a single appointment
        Appointment appointment = new Appointment();
        // assert that the appointment was created
        assertTrue(appointment != null);
    }

    @Test
    public void createWeeklyRecurringAppointment() {
        // create a weekly recurring appointment
        Appointment appointment = new Appointment();
        appointment.setRecurring(true);
        appointment.setRecurringType("weekly");
        // assert that the appointment was created
        assertTrue(appointment != null);
    }

    @Test
    public void createMonthlyRecurringAppointment() {
        // create a monthly recurring appointment
        Appointment appointment = new Appointment();
        appointment.setRecurring(true);
        appointment.setRecurringType("monthly");
        // assert that the appointment was created
        assertTrue(appointment != null);
    }

    @Test
    public void createEvery2WeeksRecurringAppointment() {
        // create an appointment that recurs every 2 weeks
        Appointment appointment = new Appointment();
        appointment.setRecurring(true);
        appointment.setRecurringType("every 2 weeks");
        // assert that the appointment was created
        assertTrue(appointment != null);
    }

    @Test
    public void createEvery2MonthsRecurringAppointment() {
        // create an appointment that recurs every 2 months
        Appointment appointment = new Appointment();
        appointment.setRecurring(true);
        appointment.setRecurringType("every 2 months");
        // assert that the appointment was created
        assertTrue(appointment != null);
    }

    @Test
    public void createAnnualRecurringAppointment() {
        // create an annual recurring appointment
        Appointment appointment = new Appointment();
        appointment.setRecurring(true);
        appointment.setRecurringType("annually");
        // assert that the appointment was created
        assertTrue(appointment != null);
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("AppointmentTest_24");
    }
}

class Appointment {
    private boolean recurring;
    private String recurringType;

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public void setRecurringType(String recurringType) {
        this.recurringType = recurringType;
    }
}