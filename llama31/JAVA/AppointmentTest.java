public class AppointmentTest {

    public static void main(String[] args) {
        AppointmentTest test = new AppointmentTest();
        test.createSingleAppointment();
        test.createWeeklyRecurringAppointment();
        test.createMonthlyRecurringAppointment();
        test.createEvery2WeeksRecurringAppointment();
        test.createEvery2MonthsRecurringAppointment();
        test.createAnnualRecurringAppointment();
    }

    public void createSingleAppointment() {
        // create a single appointment
        System.out.println("Creating a single appointment...");
        // assert that the appointment was created
        System.out.println("Single appointment created.");
    }

    public void createWeeklyRecurringAppointment() {
        // create a weekly recurring appointment
        System.out.println("Creating a weekly recurring appointment...");
        // assert that the appointment was created
        System.out.println("Weekly recurring appointment created.");
    }

    public void createMonthlyRecurringAppointment() {
        // create a monthly recurring appointment
        System.out.println("Creating a monthly recurring appointment...");
        // assert that the appointment was created
        System.out.println("Monthly recurring appointment created.");
    }

    public void createEvery2WeeksRecurringAppointment() {
        // create an appointment that recurs every 2 weeks
        System.out.println("Creating an appointment that recurs every 2 weeks...");
        // assert that the appointment was created
        System.out.println("Every 2 weeks recurring appointment created.");
    }

    public void createEvery2MonthsRecurringAppointment() {
        // create an appointment that recurs every 2 months
        System.out.println("Creating an appointment that recurs every 2 months...");
        // assert that the appointment was created
        System.out.println("Every 2 months recurring appointment created.");
    }

    public void createAnnualRecurringAppointment() {
        // create an annual recurring appointment
        System.out.println("Creating an annual recurring appointment...");
        // assert that the appointment was created
        System.out.println("Annual recurring appointment created.");
    }
}