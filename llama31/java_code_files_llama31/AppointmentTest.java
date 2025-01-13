/*
 * Decompiled with CFR 0.152.
 */
public class AppointmentTest {
    public static void main(String[] stringArray) {
        AppointmentTest appointmentTest = new AppointmentTest();
        appointmentTest.createSingleAppointment();
        appointmentTest.createWeeklyRecurringAppointment();
        appointmentTest.createMonthlyRecurringAppointment();
        appointmentTest.createEvery2WeeksRecurringAppointment();
        appointmentTest.createEvery2MonthsRecurringAppointment();
        appointmentTest.createAnnualRecurringAppointment();
    }

    public void createSingleAppointment() {
        System.out.println("Creating a single appointment...");
        System.out.println("Single appointment created.");
    }

    public void createWeeklyRecurringAppointment() {
        System.out.println("Creating a weekly recurring appointment...");
        System.out.println("Weekly recurring appointment created.");
    }

    public void createMonthlyRecurringAppointment() {
        System.out.println("Creating a monthly recurring appointment...");
        System.out.println("Monthly recurring appointment created.");
    }

    public void createEvery2WeeksRecurringAppointment() {
        System.out.println("Creating an appointment that recurs every 2 weeks...");
        System.out.println("Every 2 weeks recurring appointment created.");
    }

    public void createEvery2MonthsRecurringAppointment() {
        System.out.println("Creating an appointment that recurs every 2 months...");
        System.out.println("Every 2 months recurring appointment created.");
    }

    public void createAnnualRecurringAppointment() {
        System.out.println("Creating an annual recurring appointment...");
        System.out.println("Annual recurring appointment created.");
    }
}
