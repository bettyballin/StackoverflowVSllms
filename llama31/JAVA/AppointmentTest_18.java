import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AppointmentTest_18_18 {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(AppointmentTest_18.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }

    public void createSingleAppointment() {
        // create a single appointment
        // assert that the appointment was created
    }

    public void createWeeklyRecurringAppointment() {
        // create a weekly recurring appointment
        // assert that the appointment was created
    }

    public void createMonthlyRecurringAppointment() {
        // create a monthly recurring appointment
        // assert that the appointment was created
    }

    public void createEvery2WeeksRecurringAppointment() {
        // create an appointment that recurs every 2 weeks
        // assert that the appointment was created
    }

    public void createEvery2MonthsRecurringAppointment() {
        // create an appointment that recurs every 2 months
        // assert that the appointment was created
    }

    public void createAnnualRecurringAppointment() {
        // create an annual recurring appointment
        // assert that the appointment was created
    }
}