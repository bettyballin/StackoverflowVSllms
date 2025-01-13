public class AppointmentTest_23_23 {

    public void createSingleAppointment() {
        // create a single appointment
        // assert that the appointment was created
        System.out.println("Creating a single appointment...");
    }

    public void createWeeklyRecurringAppointment() {
        // create a weekly recurring appointment
        // assert that the appointment was created
        System.out.println("Creating a weekly recurring appointment...");
    }

    public void createMonthlyRecurringAppointment() {
        // create a monthly recurring appointment
        // assert that the appointment was created
        System.out.println("Creating a monthly recurring appointment...");
    }

    public void createEvery2WeeksRecurringAppointment() {
        // create an appointment that recurs every 2 weeks
        // assert that the appointment was created
        System.out.println("Creating an appointment that recurs every 2 weeks...");
    }

    public void createEvery2MonthsRecurringAppointment() {
        // create an appointment that recurs every 2 months
        // assert that the appointment was created
        System.out.println("Creating an appointment that recurs every 2 months...");
    }

    public void createAnnualRecurringAppointment() {
        // create an annual recurring appointment
        // assert that the appointment was created
        System.out.println("Creating an annual recurring appointment...");
    }

    public static void main(String[] args) {
        AppointmentTest_23 test = new AppointmentTest_23();
        test.createSingleAppointment();
        test.createWeeklyRecurringAppointment();
        test.createMonthlyRecurringAppointment();
        test.createEvery2WeeksRecurringAppointment();
        test.createEvery2MonthsRecurringAppointment();
        test.createAnnualRecurringAppointment();
    }
}